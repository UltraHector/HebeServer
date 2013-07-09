package com.TroyEmpire.HebeServer.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TroyEmpire.HebeServer.IServices.INewsService;
import com.TroyEmpire.HebeServer.Services.NewsService;
import com.TroyEmpire.HebeServer.constants.NewsType;
import com.TroyEmpire.HebeServer.entities.News;

@Controller
@RequestMapping("/news")
public class NewsController {
	private INewsService newsService = new NewsService();

	@RequestMapping("/{newsType}/{clientNewsMaxId}")
	@ResponseBody
	public List<News> updateClientSideNews(@PathVariable int clientNewsMaxId,
			@PathVariable int newsType) {
		if(newsType == NewsType.教务处.ordinal())
			return newsService.getNewsByClientNewsMaxId(NewsType.教务处,
					clientNewsMaxId);
		else if(newsType == NewsType.学生处.ordinal())
			return newsService.getNewsByClientNewsMaxId(NewsType.学生处,
					clientNewsMaxId);
		else 
			return newsService.getNewsByClientNewsMaxId(null, clientNewsMaxId);
	}

}
