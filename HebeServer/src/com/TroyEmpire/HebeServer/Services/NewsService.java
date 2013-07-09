package com.TroyEmpire.HebeServer.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.TroyEmpire.HebeServer.DAO.NewsDAO;
import com.TroyEmpire.HebeServer.IDAO.INewsDAO;
import com.TroyEmpire.HebeServer.IServices.INewsService;
import com.TroyEmpire.HebeServer.constants.Constant;
import com.TroyEmpire.HebeServer.constants.NewsType;
import com.TroyEmpire.HebeServer.entities.News;
import com.TroyEmpire.HebeServer.util.CommonUtil;
import com.TroyEmpire.HebeServer.util.HtmlUtil;

@Service
public class NewsService implements INewsService {

	private INewsDAO dao = new NewsDAO();

	@Override
	public void saveNews(News news) {
		dao.save(news);
	}

	@Override
	@Scheduled(fixedRate = Constant.INTERVAL_GRAB_NEWS)
	public void grabNewsServiceSchedulely() {
		// Grab Jwc News Service
		grabJwcNews();
		grabXscNews();
	}

	private void grabJwcNews() {
		try {
			List<News> newsList = new ArrayList<News>();
			// find the last news
			News latestNews = dao.findLatestNews(NewsType.教务处);
			Document doc = Jsoup.connect(Constant.JWC_NEWS_PORTAL_URL)
					.method(Method.GET).execute().parse();
			// the charming characteristic 80%
			List<Element> eles = doc
					.getElementsByAttributeValue("width", "80%");
			for (Element ele : eles) {
				News news = new News();
				Element child = ele.child(1);
				if (!child.html().trim()
						.equalsIgnoreCase(latestNews.getTitle())) {
					news.setTitle(ele.child(1).html().trim());
					news.setNewsType(NewsType.教务处);
					news.setPublishDate(Calendar.getInstance().getTime());
					// get the content of the news
					news.setContent(getJwcNewsContent(Constant.JWC_ROOT_URL
							+ child.attr("href")));
					newsList.add(news);
				} else
					break;
			}
			List<News> reversedList = CommonUtil
					.reverse((ArrayList<News>) newsList);
			dao.saveAll(reversedList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void grabXscNews() {
		List<News> newsList = new ArrayList<News>();
		// find the last news
		News latestNews = dao.findLatestNews(NewsType.学生处);
		Document doc;
		try {
			doc = Jsoup.connect(Constant.XSC_PORTAL_URL).method(Method.GET)
					.execute().parse();
			// the charming characteristics
			List<Element> eles = doc.getElementById("middle")
					.getElementsByAttributeValue("class", "mframe").get(0)
					.getElementsByAttributeValue("class", "nl").get(0)
					.children();
			for (Element ele : eles) {
				News news = new News();
				Element child = ele.child(0).child(0);
				if (!child.html().trim()
						.equalsIgnoreCase(latestNews.getTitle())) {
					news.setNewsType(NewsType.学生处);
					news.setPublishDate(Calendar.getInstance().getTime());
					news.setTitle(child.html().trim());
					// get the content of the news
					news.setContent(getXscNewsContent(Constant.XSC_PORTAL_URL
							+ child.attr("href")));
					newsList.add(news);
				} else
					break;
			}
			List<News> reversedList = CommonUtil
					.reverse((ArrayList<News>) newsList);
			dao.saveAll(reversedList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getXscNewsContent(String url) {
		try {
			String content = Jsoup.connect(url).execute().parse()
					.getElementById("BodyLabel").html();
			content = HtmlUtil.optimizeHtmlByDeleteRangeMark(content, "style",
					"\">");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content,
					"&nbsp;");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content,
					"\n");
			return content;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getJwcNewsContent(String url) {
		try {
			String content = Jsoup.connect(url).method(Method.GET).execute()
					.parse().getElementsByAttributeValue("class", "news")
					.get(0).html();
			content = HtmlUtil.optimizeHtmlByDeleteRangeMark(content, "style",
					"\">");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content,
					"&nbsp;");
			content = HtmlUtil.optimizeHtmlByDeleteSpecificSlice(content,
					"\n");
			return content;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<News> getNewsByClientNewsMaxId(NewsType type,
			int clientNewsMaxId) {
		if (type == NewsType.教务处)
			return (List<News>)CommonUtil.reverse(dao.findNewsAboveAnId(NewsType.教务处, clientNewsMaxId));
		else if (type == NewsType.学生处)
			return (List<News>)CommonUtil.reverse(dao.findNewsAboveAnId(NewsType.学生处, clientNewsMaxId));
		else if (type == null)
			return (List<News>)CommonUtil.reverse(dao.findNewsAboveAnId(clientNewsMaxId));
		return null;
	}

}
 