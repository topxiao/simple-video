<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <title>首页</title>
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
            "data": {
                "items": [
                    {
                        "icon": "https://internal-amis-res.cdn.bcebos.com/images/icon-1.png",
                        "text": "导航1"
                    },
                    {
                        "icon": "https://internal-amis-res.cdn.bcebos.com/images/icon-1.png",
                        "text": "导航2"
                    },
                    {
                        "icon": "https://internal-amis-res.cdn.bcebos.com/images/icon-1.png",
                        "text": "导航3"
                    },
                    {
                        "icon": "https://internal-amis-res.cdn.bcebos.com/images/icon-1.png",
                        "text": "导航4"
                    }
                ]
            },
            "body": [
                {
                    "type": "grid-nav",
                    "source": "${items}"
                },
                {
                    "type": "divider"
                },
                {
                    "type": "grid-nav",
                    "name": "items"
                }
            ]
        }
        </#noparse>

        let amisScoped = amis.embed('#root', json);
    })();
</script>
</body>
</html>
