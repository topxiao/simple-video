<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <title>amis operate</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, maximum-scale=1"
    />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <link rel="stylesheet" href="https://houtai.baidu.com/v2/csssdk"/>
    <style>
        html,
        body,
        .app-wrapper {
            position: relative;
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div id="root" class="app-wrapper"></div>
<script src="https://houtai.baidu.com/v2/jssdk"></script>
<script type="text/javascript">
    (function () {
        let amis = amisRequire('amis/embed');

        //页面配置
        <#noparse >
        let json = {
            "type": "page",
            "body": {
                "type": "video",
                "src": "http://localhost:9000/assets/0401.mp4",
                "videoType": "video/mp4",
                "poster": "https://internal-amis-res.cdn.bcebos.com/images/2019-12/1577157239810/da6376bf988c.png"
            }
        }
        </#noparse>

        let amisScoped = amis.embed('#root', json);
    })();
</script>
</body>
</html>
