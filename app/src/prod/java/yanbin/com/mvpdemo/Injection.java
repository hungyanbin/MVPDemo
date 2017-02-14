package yanbin.com.mvpdemo;

public class Injection {

    private static ResourceService resourceService;

    public static ResourceService getResourceService(){
        if(resourceService == null){
            resourceService = new ResourceServiceImp();
        }
        return resourceService;
    }
}
