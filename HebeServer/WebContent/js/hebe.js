$(document).ready(function(){
    $("#bugReportButton").click(function(){
		$("#bugReportForm").toggle('fast');
	});
    $(".uploadCellButton").click(function(){
		$(this).parent().children(".uploadCellDiv").toggle('fast');
	});
    $(".showBuildingInfoButton").click(function(){
    	$(this).next(".buildingInfoDiv").toggle('fast');
	});
    
    $("#uploadYellowPageButton").click(function(){
    	$(this).next("#uploadYellowPageDiv").toggle('fast');
	});
    $("#uploadPublicIdeaButton").click(function(){
    	$(this).next("#uploadPublicIdeaDiv").toggle('fast');
	});
});

function switchMaintenanceToBuilding(){
	$("#maintenance_public_idea").hide('fast');
	$("#maintenance_yellow_page").hide('fast');
	$("#maintenance_building").show('fast');
	$("#maintenance_manual").hide('fast');
	$("#maintenance_buildingLink").css({"background":"#f0f0f0","color":"black"});
	$("#maintenance_yellowPageLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_publicIdeaLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_manualLink").css({"background":"#485e49","color":"white"});
}


function switchMaintenanceToPublicIdea(){
	$("#maintenance_yellow_page").hide('fast');
	$("#maintenance_building").hide('fast');
	$("#maintenance_public_idea").show('fast');
	$("#maintenance_manual").hide('fast');
	$("#maintenance_buildingLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_yellowPageLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_publicIdeaLink").css({"background":"#f0f0f0","color":"black"});
	$("#maintenance_manualLink").css({"background":"#485e49","color":"white"});
}


function switchMaintenanceToYellowPage(){
	$("#maintenance_building").hide('fast');
	$("#maintenance_public_idea").hide('fast');
	$("#maintenance_yellow_page").show('fast');
	$("#maintenance_manual").hide('fast');
	$("#maintenance_buildingLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_yellowPageLink").css({"background":"#f0f0f0","color":"black"});
	$("#maintenance_publicIdeaLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_manualLink").css({"background":"#485e49","color":"white"});
}

function switchMaintenanceToManual(){
	$("#maintenance_building").hide('fast');
	$("#maintenance_public_idea").hide('fast');
	$("#maintenance_yellow_page").hide('fast');
	$("#maintenance_manual").show('fast');
	$("#maintenance_buildingLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_yellowPageLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_publicIdeaLink").css({"background":"#485e49","color":"white"});
	$("#maintenance_manualLink").css({"background":"#f0f0f0","color":"black"});
}