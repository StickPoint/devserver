package com.dev.tool.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puye(0303)
 * @since 2023/2/7
 */
@RestController
@RequestMapping("/plugin")
public class SysPluginController {

    @RequestMapping("/download")
    public void downloadPlugin(){

    }
}
