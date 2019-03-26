package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//开启配置文件服务端
public class Springcloud_config_server_3344_app {
    public static void main(String [] args){
        SpringApplication.run(Springcloud_config_server_3344_app.class,args);
    }
}

/**
 *整合github
 * 先在github中创建一个项目之后记住路径下载到本地；（eg：E:\workspace\springcloud-config-github\springcloud-config）
 * 在本地路径中创建一个application.yml并进行配置（必须以utf-8编码保存），之后上传到github中
 * $ git status  查看本地库状态
 * $ git add .   将所有文件进行提交
 * $ git commit -m "一个yml多个环境配置"            准备提交
 * $ git push origin master             推送到主分支
 * 创建config-server客户端；通过引入相应依赖
 *
 *
 *
 */
