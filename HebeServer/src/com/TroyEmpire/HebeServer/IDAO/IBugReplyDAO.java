package com.TroyEmpire.HebeServer.IDAO;

import java.math.BigDecimal;
import java.util.List;

import com.TroyEmpire.HebeServer.entities.BugReply;

public interface IBugReplyDAO extends IDAO<BugReply, BigDecimal> {
	public List<BugReply> getBugReplyByBugId(int id);

}
