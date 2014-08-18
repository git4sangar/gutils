UiManager = function() {
	var VIEW_PAGES = [];
	var PREFERENCE = {};
	var USER_PREFERENCE = {};
	var isLoaded = false;
	var isUserPreferenceLoaded = false;
	var PAGES = {
		landingContainer : {
			xtype : 'landingContainer'
		},
		segmentPlanningContainer : {
			xtype : 'segmentPlanningContainer',
			itemId : 'layoutSegmentPlanning'
		},
		rfpContainer : {
			xtype : 'rfpContainer'
		},
		ioRelease : {
			xtype : 'ioRelease'
		},
		supplySourceRep : {
			xtype : 'supplySourceRep'
		}, 
		summary : {
			xtype : 'summary'
		}
		
	};
	
	var traverse  = function(k, o) {
		var keys = k.split(".");
		var r = o;
		for ( var k in keys) {
			if (r.hasOwnProperty(keys[k])) {
				r = r[keys[k]];
			}
		}
		return r;
	};

	String.prototype.supplant = function(o) {
		var whitespace = /[/\f/\n/\r/\t/\v/\u00A0/\u2028/\u2029]/g
		return this.replace(/{([^{}]*)}/g, function(a, b) {
			if (whitespace.test(a)) {
				return a;
			}
			
			r = traverse(b, o);
			
			return typeof r === 'string' || typeof r === 'number'
					|| typeof r === 'object' || typeof r === 'array'
					|| typeof r === 'boolean' || typeof r === 'null' ? r : a;
		});
	};
	
	
	function loadViewPages(pages) {
		for ( var i in pages) {
			if (PAGES[i]) {
				VIEW_PAGES.push(PAGES[i]);
			}
		}
	}

	function loadAgencyPreference(preferences) {
		PREFERENCE = preferences[0];

	}

	function loadUserPreference(userPreference) {
		USER_PREFERENCE = userPreference[0];

	}

	function init(param) {
		loadViewPages(param.pages);
		if (param.preferences) {
			loadAgencyPreference(param.preferences);
		}
		if (param.userPreference) {
			loadUserPreference(param.userPreference);
		}
	}

	return {
		init : function(param) {
			init(param);
		},
		getViewPages : function() {
			return VIEW_PAGES;
		},
		getPreferencebyKey : function(key) {
			return traverse(key ,PREFERENCE);
		},
		getUserPreferencebyKey : function(key) {
			return traverse(key ,USER_PREFERENCE);
		}

	}
}();