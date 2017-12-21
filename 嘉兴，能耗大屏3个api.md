* http://localhost:8080/jx/api/top5Companys

        [
          {
            "companyName": "亮兮柯电气有限公司",
            "zxygdn": 1190.06
          },
          {
            "companyName": "雅莹集团",
            "zxygdn": 284.5
          },
          {
            "companyName": "捷顺旅游制品有限公司",
            "zxygdn": 193.94
          }
        ]
    
* http://localhost:8080/jx/api/realTimeCompanys
    
        [
          {
            "companyName": "亮兮柯电气有限公司",
            "waterValue": 0.0,
            "zxygdn": 1190.71
          },
          {
            "companyName": "雅莹集团",
            "waterValue": 0.0,
            "zxygdn": 284.55
          },
          {
            "companyName": "捷顺旅游制品有限公司",
            "waterValue": 0.0,
            "zxygdn": 193.98
          }
        ]

* http://localhost:8080/jx/api/hoursViews?companyCode=1
* companyCode,为1,2,3分别代表3家企业，分别为：
* 1：雅莹集团
* 2：亮兮柯电气有限公司
* 3：捷顺旅游制品有限公司
* 能耗大屏显示的时候显示一下公司名称，请求的时候用companyCode请求


        [
          {
            "hour": 0,
            "zxygdn": 0.0
          },
          {
            "hour": 1,
            "zxygdn": 0.05999756
          },
          {
            "hour": 2,
            "zxygdn": 0.06997681
          },
          {
            "hour": 3,
            "zxygdn": 0.070007324
          },
          {
            "hour": 4,
            "zxygdn": 0.08001709
          },
          {
            "hour": 5,
            "zxygdn": 0.08999634
          },
          {
            "hour": 6,
            "zxygdn": 0.22998047
          },
          {
            "hour": 7,
            "zxygdn": 0.4500122
          },
          {
            "hour": 8,
            "zxygdn": 1.0299988
          },
          {
            "hour": 9,
            "zxygdn": 1.1199951
          },
          {
            "hour": 10,
            "zxygdn": 1.0700073
          },
          {
            "hour": 11,
            "zxygdn": 1.0
          },
          {
            "hour": 12,
            "zxygdn": 0.88998413
          },
          {
            "hour": 13,
            "zxygdn": 0.9700012
          },
          {
            "hour": 14,
            "zxygdn": 1.0299988
          },
          {
            "hour": 15,
            "zxygdn": 0.87002563
          },
          {
            "hour": 16,
            "zxygdn": 0.8699951
          },
          {
            "hour": 17,
            "zxygdn": 0.6199951
          },
          {
            "hour": 18,
            "zxygdn": 0.22000122
          },
          {
            "hour": 19,
            "zxygdn": 0.22000122
          },
          {
            "hour": 20,
            "zxygdn": 0.19000244
          },
          {
            "hour": 21,
            "zxygdn": 0.13998413
          },
          {
            "hour": 22,
            "zxygdn": 0.02999878
          }
        ]