

@Controller("xxxxController")
@RequestMapping("/${managePath}")
@Before(AdminLoginInterceptor.class)
public class IndexController extends BaseController {
    private static final String FTL_PATH = "/manage";
    @Resource
    private IMemberService memberService;
    @Resource
    private ICommonService commonService;

    @RequestMapping("/index")
    public String index(Model model){
        Properties props = System.getProperties();
        //java版本
        String javaVersion = props.getProperty("java.version");
        //操作系统名称
        String osName = props.getProperty("os.name");
        //服务器IP
        String serverIP = request.getLocalAddr();
        //客户端IP
        String clientIP = request.getRemoteHost();
        //WEB服务器
        String webVersion = request.getServletContext().getServerInfo();
        String cpu = Runtime.getRuntime().availableProcessors() + "核";
        String totalMemory = (Runtime.getRuntime().totalMemory()/1024/1024) + "M";
        String freeMemory = (Runtime.getRuntime().freeMemory()/1024/1024) + "M";
        String maxMemory = (Runtime.getRuntime().maxMemory()/1024/1024) + "M";
        String mysqlVersion = commonService.getMysqlVsesion();
        String webRootPath = request.getSession().getServletContext().getRealPath("");
 
        return FTL_PATH + "/index";
    }

    /**
     * 登录页面
     * @return
     */
    @Clear()
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
    	  Oauth oauth=new Oauth("xxxxx");
          String blackUrl="/qweasd";
          String loginUrl=oauth.getOauthLoginUrl(blackUrl);
          return "redirect:"+loginUrl;
    }


}
