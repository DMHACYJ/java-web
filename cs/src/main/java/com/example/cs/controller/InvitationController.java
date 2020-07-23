package com.example.cs.controller;

import com.example.cs.entity.Invitation;
import com.example.cs.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 帖子控制器
 */
@Controller
public class InvitationController {
    @Autowired
    private InvitationService invitationService;

    /**
     * 首页（默认查询全部帖子）
     * @param map
     * @return
     */
    @RequestMapping({"/","/index"})
    public String index(Map<String,Object> map){
        List<Invitation> invitationList =  invitationService.findAll();
        map.put("invitationList", invitationList);
        return "index";
    }

    /**
     * 首页（默认查询全部帖子）
     * @return
     */
    @RequestMapping("/toindex")
    public String toindex(Model model, HttpServletRequest request){
        List<Invitation> invitationList =  invitationService.findAll();
        String userName = request.getParameter("userName");
        model.addAttribute("invitationList", invitationList);
        model.addAttribute("userName", userName);
        return "index_login_root";
    }


    @RequestMapping("/goadd")
    public String goadd(Model model, HttpServletRequest request){
        String userName = request.getParameter("userName");
        String role = request.getParameter("role");
        model.addAttribute("userName",userName);
        model.addAttribute("role",role);
        return "addInvitation";
    }

    /**
     * 帖子查询
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/goquery")
    public String goquery(Model model, HttpServletRequest request){
        String url = "index";
        //获取帖子标题（查询条件）
        String title = request.getParameter("title");
        String role = request.getParameter("role");
        String userName = request.getParameter("userName");
        if(userName!=null){
            model.addAttribute("userName",userName);
            if(role !=null){
                if(role.equals("root") || role.equals("admin") || userName.equals("root") || userName.equals("admin")){
                    url = "index_login_root";
                }else {
                    url = "index_login";
                }
            }
        }


        List<Invitation> invitations = invitationService.findAllByTitleLike(title);
        model.addAttribute("invitationList",invitations);

        return url;
    }

    @RequestMapping("/saveInvitation")
    public String goadd(Model model,Invitation invitation,HttpServletRequest request){
        String url = "index_login";
        String userName = request.getParameter("userName");
        String role = request.getParameter("role");
        invitationService.save(invitation);
        List<Invitation> invitationList =  invitationService.findAll();
        model.addAttribute("invitationList", invitationList);
        model.addAttribute("userName", userName);
        model.addAttribute("role", role);
        if(role.equals("root") || role.equals("admin") || userName.equals("root") || userName.equals("admin")){
            url = "index_login_root";
        }
        return url;
    }

    @RequestMapping("/godel")
    public String godel(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String role = request.getParameter("role");
        invitationService.delete(Integer.parseInt(id));
        List<Invitation> invitationList =  invitationService.findAll();
        model.addAttribute("invitationList", invitationList);
        model.addAttribute("userName",userName);
        return "index_login_root";
    }

    @RequestMapping("/goupdate")
    public String goupdate(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String role = request.getParameter("role");
        Invitation invitation =  invitationService.findById(Integer.parseInt(id));
        model.addAttribute("invitation",invitation);
        model.addAttribute("userName",userName);
        model.addAttribute("role",role);
        return "editInvitation";
    }
}