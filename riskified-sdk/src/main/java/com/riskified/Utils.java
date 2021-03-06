package com.riskified;

public class Utils {

    public static final String DEBUG_ENVIRONMENT = "http://localhost:3000";
    public static final String SANDBOX_ENVIRONMENT = "https://sandbox.riskified.com";
    public static final String PRODUCTION_ENVIRONMENT = "https://wh.riskified.com";
    public static final String PRODUCTION_SYNC_ANALYZE_ENVIRONMENT = "https://wh-sync.riskified.com";

    public static String getBaseUrlFromEnvironment(Environment environmentType) {
        String url = null;
        if (environmentType != null) {
            switch (environmentType) {
                case DEBUG:
                    url = DEBUG_ENVIRONMENT;
                    break;
                case SANDBOX:
                    url = SANDBOX_ENVIRONMENT;
                    break;
                case PRODUCTION:
                    url = PRODUCTION_ENVIRONMENT;
                    break;
            }
        }
        return url;
    }
    
    public static String getBaseUrlSyncAnalzyeFromEnvironment(Environment environmentType) {
        String url = null;
        if (environmentType != null) {
            switch (environmentType) {
                case DEBUG:
                    url = DEBUG_ENVIRONMENT;
                    break;
                case SANDBOX:
                    url = SANDBOX_ENVIRONMENT;
                    break;
                case PRODUCTION:
                    url = PRODUCTION_SYNC_ANALYZE_ENVIRONMENT;
                    break;
            }
        }
        return url;
    }
}
