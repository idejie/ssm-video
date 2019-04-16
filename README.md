# SSM Video
> A web framework to generate videos from pictures and subtitles.
> 
>一个**图片生成视频**的ssm框架

## Usage
 - `IntelliJ IDEA` to open it
 - sql structure and example data in `Demo.sql`
 - configuration
    - ffmpeg: `src/main/java/com/grey/ssm/video/utils/Constants.java`
    - jdbc: `src/main/resources/jdbc.properties`
## Functions
- 用户管理：实现了基本的登录注册和授权管理
- 视频生成
    - 实现了一个简单的爬虫，根据[关键词,分辨率]搜索图片（来源360搜索）
    - 实现了ffmpeg用图片生成视频，包括bgm、台词的添加，每张图片的时长控制
 - 视频管理
    - 视频的添加、删除
    - 资源的添加、删除 

