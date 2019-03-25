# SSM Video
> A web framework to generate videos from pictures and subtitles.

## Usage
 - use `IntelliJ IDEA` to open it
 - sql structure and example data in `Demo.sql`

## Functions
- 用户管理：实现了基本的登录注册和授权管理
- 视频生成
    - 实现了一个简单的爬虫，根据关键词，搜索图片（来源360搜索）
    - 实现了ffmpeg用图片生成视频，包括bgm、台词的添加，以及分辨率、手机版的banner模糊化。
## TODO
- 实现并行处理，加快ffmpeg的处理速度

- 增加异常处理

- 欢迎issue & PR

