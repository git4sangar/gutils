var preference=[{"tenantId":1,"agencyPreferenceId":1,"createdBy":0,"maxUsers":10,"lastModifiedBy":0,"agency":{"tenantId":1,"createdBy":0,"holdingCompanyId":0,"lastModifiedBy":0,"lastModifiedDate":"2014-03-10 11:34:46.0","isDeleted":0,"createdDate":"2014-03-10 11:34:46.0","agencyName":"Agency1","agencyId":1},"lastModifiedDate":"2014-03-28 16:33:27.0","logoUrl":"/mediaplanning/images/adagencylogo.png","maxFileSize":10,"createdDate":"2014-03-10 11:54:50.0","timeZoneId":1,"currency":{"currencyDesc":"US Dollar","isoCurrencyCode":"USD","createdBy":0,"currencySymbol":"$","currencyId":1,"lastModifiedBy":0,"lastModifiedDate":"2014-03-25","isDeleted":0,"createdDate":"2014-03-25"}}];
        		var userPreference=[{"numberFormatValue":"xx,xxx.xxx","noOfRowsMyMediaPlans":10,"locale":{"localeId":1,"languageCode":"en","countryName":"United States","createdBy":0,"lastModifiedBy":0,"countryCode":"US","lastModifiedDate":"2014-03-10 10:41:27.0","createdDate":"2014-03-10 10:41:27.0","languageName":"English","isEnabled":1},"dateTimePreference":{"weekStartDay":{"weekDay":"Sunday-Monday","createdBy":0,"isDefault":1,"lastModifiedBy":0,"lastModifiedDate":"2014-03-25 20:00:32.0","weekStartDayId":1,"createdDate":"2014-03-25 20:00:32.0"},"createdBy":0,"lastModifiedBy":0,"timeFormat":{"createdBy":0,"isDefault":0,"lastModifiedBy":0,"formatValue":"H.i","lastModifiedDate":"2014-03-10 11:03:35.0","timeFormatId":4,"createdDate":"2014-03-10 11:03:35.0","formatExample":"23.00"},"lastModifiedDate":"2014-03-10 14:39:19.0","dateFormat":{"createdBy":0,"isDefault":0,"lastModifiedBy":0,"formatValue":"m-d-Y","lastModifiedDate":"2014-03-10 10:32:34.0","dateFormatId":2,"createdDate":"2014-03-10 10:32:34.0","formatExample":"02-05-2005"},"createdDate":"2014-03-10 14:39:19.0","dateTimePreferenceId":1},"numberFormatExample":"12,345.678","timeZone":{"timeZoneDesc":"Eastern","timeZoneCode":"US/Eastern","createdBy":0,"tzOffsetType":{"createdBy":0,"lastModifiedBy":0,"lastModifiedDate":"2014-03-10 10:51:30.0","offsetInterval":"60","createdDate":"2014-03-10 10:51:30.0","offsetDescription":"Hourly offsets - Default offset type","tzOffsetTypeId":3},"isDefault":1,"offsetValue":-18000,"lastModifiedBy":0,"lastModifiedDate":"2014-03-10 11:00:14.0","timeZoneName":"(UTC-05:00) Eastern Time US (Automatically adjusts for daylight savings)","createdDate":"2014-03-10 11:00:14.0","isEnabled":1,"timeZoneId":3},"party":{"webapiRole":"","loginId":"madhu@yume.com","lastLoginDate":"2014-03-10 14:38:44.0","secretAnswer":"Black","agencies":[{"tenantId":1,"createdBy":0,"holdingCompanyId":0,"lastModifiedBy":0,"lastModifiedDate":"2014-03-10 11:34:46.0","isDeleted":0,"createdDate":"2014-03-10 11:34:46.0","agencyName":"Agency1","agencyId":1}],"companyName":"Agency1","password":"test12","contact":{"tenantId":0,"middleName":"party Middle Name","lastName":"party Last Name","phoneByHomePhoneId":{"extension":124,"phoneNumber":77777777,"createdBy":0,"areaCode":44,"lastModifiedBy":0,"countryCode":91,"phoneId":5,"lastModifiedDate":"2014-03-10 14:27:38.0","createdDate":"2014-03-10 00:00:00.0"},"isDeleted":0,"phoneByWorkPhoneId":{"extension":124,"phoneNumber":77777777,"createdBy":0,"areaCode":44,"lastModifiedBy":0,"countryCode":91,"phoneId":5,"lastModifiedDate":"2014-03-10 14:27:38.0","createdDate":"2014-03-10 00:00:00.0"},"contactId":5,"createdBy":0,"email":"abcd@xyz.com","lastModifiedBy":0,"lastModifiedDate":"2014-03-10 14:37:33.0","contactType":{"createdBy":0,"lastModifiedBy":0,"contactTypeDesc":"The contact information of a party","lastModifiedDate":"2014-03-10 10:04:06.0","contactTypeName":"Party Contact","isDeleted":0,"createdDate":"2014-03-10 10:04:06.0","contactTypeId":5},"firstName":"party First Name","createdDate":"2014-03-10 14:37:33.0","phoneByFaxPhoneId":{"extension":124,"phoneNumber":77777777,"createdBy":0,"areaCode":44,"lastModifiedBy":0,"countryCode":91,"phoneId":5,"lastModifiedDate":"2014-03-10 14:27:38.0","createdDate":"2014-03-10 00:00:00.0"}},"isTcAccepted":0,"isLocked":0,"disableReason":"","isActivated":0,"registrationDate":"2014-03-10 14:38:44.0","createdBy":0,"partyId":1,"secretQuestionId":0,"tcAcceptedDate":"2014-03-10 14:38:44.0","lastModifiedBy":0,"lastModifiedDate":"2014-03-10 14:38:44.0","mustChangePassword":0},"noOfRowsLaunchedPlans":10,"currency":{"currencyDesc":"US Dollar","isoCurrencyCode":"USD","createdBy":0,"currencySymbol":"$","currencyId":1,"lastModifiedBy":0,"lastModifiedDate":"2014-03-25","isDeleted":0,"createdDate":"2014-03-25"},"createdBy":0,"partyId":1,"uiComplexity":"Advanced","maxConcurrentUsers":5,"lastModifiedBy":0,"lastModifiedDate":"2014-03-10 14:51:04.0","createdDate":"2014-03-10 14:51:04.0","noOfDaysMyMediaPlans":120,"noOfDaysLaunchedPlans":120}];
        		var param = {pages : ['supplySourceRep'],preferences:preference,userPreference:userPreference};
        		var controller = [];
        		var router = [{"mediaPlanStatus":{"mediaPlanStatusName":"Completed","createdBy":0,"mediaPlanStatusSequenceId":5,"lastModifiedBy":0,"mediaPlanStatusId":32,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":9,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":0},{"mediaPlanStatus":{"mediaPlanStatusName":"Cancelled","createdBy":0,"mediaPlanStatusSequenceId":7,"lastModifiedBy":0,"mediaPlanStatusId":51,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":10,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":0},{"mediaPlanStatus":{"mediaPlanStatusName":"Primary Attribute","createdBy":0,"mediaPlanStatusSequenceId":1,"lastModifiedBy":0,"mediaPlanStatusId":1,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":1,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":1},{"mediaPlanStatus":{"mediaPlanStatusName":"Segment Planning","createdBy":0,"mediaPlanStatusSequenceId":2,"lastModifiedBy":0,"mediaPlanStatusId":11,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":2,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":2},{"mediaPlanStatus":{"mediaPlanStatusName":"RFP Release","createdBy":0,"mediaPlanStatusSequenceId":3,"lastModifiedBy":0,"mediaPlanStatusId":21,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":3,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":3},{"mediaPlanStatus":{"mediaPlanStatusName":"IO Release","createdBy":0,"mediaPlanStatusSequenceId":4,"lastModifiedBy":0,"mediaPlanStatusId":31,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":4,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":4},{"mediaPlanStatus":{"mediaPlanStatusName":"Launched","createdBy":0,"mediaPlanStatusSequenceId":6,"lastModifiedBy":0,"mediaPlanStatusId":41,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":5,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":6},{"mediaPlanStatus":{"mediaPlanStatusName":"Expired","createdBy":0,"mediaPlanStatusSequenceId":8,"lastModifiedBy":0,"mediaPlanStatusId":52,"isDeleted":0},"createdBy":0,"agencyMediaPlanStatusId":11,"lastModifiedBy":0,"agency":{"agencyId":1},"sequenceId":8}];

			
RouterManager = function() {
	var ROUTERS = {};
	var CONTROLLERS = {};
	var isLoaded = false;

	function load(records) {
		var previousRecord;
		for ( var i in records) {

			var record = records[i];
			var currentStatusId = record.mediaPlanStatus.mediaPlanStatusName;
			ROUTERS[currentStatusId] = {
				raw : record
			};

			var current = ROUTERS[currentStatusId];

			var previous;
			var previiousId;

			if (previousRecord) {
				previousId = previousRecord.mediaPlanStatus.mediaPlanStatusName;

				previous = ROUTERS[previousId];

				previous.next = currentStatusId;
				current.previous = previousId;
			}

			previousRecord = record;

		}
	}

	function perform(id, obj) {
		var controller = CONTROLLERS[id];
		console.log (id+" :id controller:"+controller);
		if (controller && controller.perform) {
			controller.perform(obj);
		}
	}

	function beforePerform(id, obj) {
		var controller = CONTROLLERS[id];
		if (controller && controller.beforePerform) {
			controller.beforePerform(obj);
		}
	}

	return {
		load : function(records) {
			if (!isLoaded) {
				load(records);
			}
			isLoaded = true;
		},
		register : function(id, controller) {
			if (!CONTROLLERS[id]) {
				CONTROLLERS[id] = controller;
			}
			return ROUTERS[id] && ROUTERS[id].raw ? ROUTERS[id].raw.mediaPlanStatus.mediaPlanStatusSequenceId : undefined;
		},
		next : function(id, obj) {			
			var nextId = ROUTERS[id].next;
			perform(nextId, obj);
		},
		back : function(id, obj) {
			var backId = ROUTERS[id].previous;
			perform(backId, obj);
		},
		goTo : function(id, obj) {
			console.log(id);
			perform(id, obj);
		},
		initiated : function(id, obj) {
			beforePerform(id, obj);
		},
		getAgencyMediaPlanStatus : function(id) {
			return ROUTERS[id] ? ROUTERS[id].raw : undefined;
		},
		getRouter : function() {
			console.log(Ext.JSON.encode(ROUTERS));
		}, 
		getSequenceId : function(key) {
			return ROUTERS[id].raw.mediaPlanStatus.mediaPlanStatusSequenceId;
		},
		getNextSequenceId : function(key) {
			var nextId = ROUTERS[key].next;
			return ROUTERS[nextId].raw.mediaPlanStatus.mediaPlanStatusSequenceId;
		}

	}
}();

MediaPlanWorkflow = function() {
	return {
		PRIMARY_ATTRIBUTE : "Primary Attribute",
		SEGMENT_PLANNING : "Segment Planning",
		RFP_RELEASE : "RFP Release",
		IO_RELEASE : "IO Release",
		LAUNCHED : "Launched",
		MP_LANDING : "MP_Landing",
		MP_SUMMARY : "Completed"
	}
}();