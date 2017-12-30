### 嘉兴，尖峰平谷总api
* http://localhost:6556/jx/api/tswkZJFPGViews?companyCode=1&pCode=65381
* 参数，companyCode 为公司的编号
* 参数，pCode为公司电表的编号，如果电表为编号为0，查询公司所有的电表总加。如果不为0，查询其中1块电表的数据
* 返回，时间，从周一开始
* 返回，Z,J,F,P,G分别代表总，尖，峰，平，谷。平的数据暂时不用显示
*       [
          {
            "time": "2017-12-25",
            "zxygdnZ": 13.710022,
            "zxygdnJ": 1.3799992,
            "zxygdnF": 9.100006,
            "zxygdnP": 0.0,
            "zxygdnG": 3.2299957
          },
          {
            "time": "2017-12-26",
            "zxygdnZ": 13.779999,
            "zxygdnJ": 1.4400005,
            "zxygdnF": 9.149994,
            "zxygdnP": 0.0,
            "zxygdnG": 3.1900024
          },
          {
            "time": "2017-12-27",
            "zxygdnZ": 10.339996,
            "zxygdnJ": 0.0,
            "zxygdnF": 7.330002,
            "zxygdnP": 0.0,
            "zxygdnG": 3.0100021
          }
        ]
* http://localhost:6556/jx/api/tswkZJFPGViews?companyCode=1&pCode=0
*       [
          {
            "time": "2017-12-25",
            "zxygdnZ": 13.710022,
            "zxygdnJ": 1.3799992,
            "zxygdnF": 9.100006,
            "zxygdnP": 0.0,
            "zxygdnG": 3.2299957
          },
          {
            "time": "2017-12-26",
            "zxygdnZ": 13.779999,
            "zxygdnJ": 1.4400005,
            "zxygdnF": 9.149994,
            "zxygdnP": 0.0,
            "zxygdnG": 3.1900024
          },
          {
            "time": "2017-12-27",
            "zxygdnZ": 10.439972,
            "zxygdnJ": 0.0,
            "zxygdnF": 7.430008,
            "zxygdnP": 0.0,
            "zxygdnG": 3.0100021
          }
        ]