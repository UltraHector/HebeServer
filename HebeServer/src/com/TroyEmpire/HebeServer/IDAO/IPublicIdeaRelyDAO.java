package com.TroyEmpire.HebeServer.IDAO;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.HebeServer.entities.BugReply;
import com.TroyEmpire.HebeServer.entities.PublicIdeaReply;

public interface IPublicIdeaRelyDAO extends IDAO<PublicIdeaReply, BigDecimal> {
	public List<PublicIdeaReply> getPublicIdeaReplyByIdeaId(int id);
}
