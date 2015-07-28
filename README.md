## Purpose
A plugin to access the preference tags (settings) in config.xml via Javascript

## Usage
    cordova plugin add com.kradmi.cordova.appsettings

    AppSettings.get(
    	function(value) {
    		alert("Value: " + JSON.stringify(value));
    	},
    	function(error) {
        	alert("Error! " + JSON.stringify(error));
    }, ["Preference1", "Preference2"]);