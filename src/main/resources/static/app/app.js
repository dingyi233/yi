angular.module('app', [])
       .controller('datetimeCtrl', ['$scope', function($scope){

          $scope.data = {
            dateFormat: 'yyyy-mm-dd', // 日期格式
            timeFormat: 'hh:ii',
            maxDate: '',    // 最大日期
            minDate: '',    // 最小日期
            curDate: '',     // 初始日期
            // 验证信息
            minshow: false,
            minText: '',
            maxshow: false,
            maxText: '',
            curshow: false,
            curText: '',
            // 日期类型
            type1: 'date',
            type2: 'datetime',
            type3: 'time'
          };
          // 日期显示格式
          $scope.dateFormat = ['yyyy-mm-dd', 'yyyy/mm/dd', 'yyyy年mm月dd日'];

          // 时间显示格式
          $scope.timeFormat = ['hh:ii','hh:ii:ss', 'HH::ii', 'HH:ii:ss'];
          // 监视   $scope.data.dateFormat  和 $scope.data.timeFormat的值的变化
          $scope.$watch('data.dateFormat + data.timeFormat', function(newValue, oldValue){
            // console.log(newValue);
            // console.log(oldValue)
            if(newValue !== oldValue){
              $scope.data.maxDate = '';
              $scope.data.minDate = '';
              $scope.data.curDate = '';
            }

          }, true)
       }])
       .directive('myDatetime', function(){
         return {
           restrict: 'EA',
           scope: {
              dateformat: '=', // 日期格式
              timeformat:'=', // 时间格式
              min: '=', //最大时间
              max: '=', //最大时间
              cur: '=', // 当前日期值
              flag:'=', //判断显示隐藏boolean值
              text: '=',//判断信息的显示值
              timetype: '=' //时间类型
           },
           link: function(scope, element, attr){
             switch (scope.timetype) {
               case 'date':
                   element.datetimepicker('remove');
                   element.datetimepicker({
                     format: 'yyyy-mm-dd',
                     minView: 2, // 2 代表月视图
                     startView: 3,// 1代表天视图
                     todayHighlight: true,
                     language: "zh-CN",
                   })
                   .on('changeDate', function(e){
                    var momentFormat = formatDatetime('date', scope.dateformat);
                     // 最终的结果：
                     var result = new moment(e.date).format(momentFormat);
                     //切记：要手动设置关闭，在重新设置值，前后顺序不要变
                     element.datetimepicker('hide')
                     // ctrl.$setViewValue(result); //?
                     scope.cur = result;
                     // 比较判断
                     console.log(scope.cur)

                     // 最小值
                     if(!attr.min) {
                       console.log('初始日期进来了')
                       if(scope.max) {
                         var flag = moment(maxDate).isBefore(scope.max);
                         if(momentFormat === 'YYYY年MM月DD日'){
                           flag = !flag
                         }
                         console.log(flag)
                         if(flag){
                           scope.flag = true;
                           scope.text = '起始日期比结束日期晚，请重新设置！';
                         }else {
                           scope.flag = false;
                           scope.text = '';
                         }
                       }
                     }else if(!attr.max){
                       // 最大值设置
                       console.log('结束日期进来了')
                       if(scope.min){
                          var flag = moment(scope.min).isBefore(result);
                          if(momentFormat === 'YYYY年MM月DD日'){
                            flag = !flag
                          }
                          console.log(scope.min)
                          console.log(momentFormat);
                          console.log(result)
                          console.log(flag);
                         if(!flag){
                           scope.flag = true;
                           scope.text = '起始日期比结束日期晚，请重新设置！!';
                         }else {
                           scope.flag = false;
                           scope.text = '';
                         }
                       }
                     }else {
                       // 初始值设置
                       console.log('初始值进来了')
                       console.log(scope.min);
                       console.log(scope.max)
                       if(scope.min || scope.max){
                           var flag = moment(result).isBetween(scope.min, scope.max);
                              console.log(flag)
                            if(momentFormat === 'YYYY年MM月DD日'){
                              flag = !flag;
                            }
                           if(flag){
                                scope.flag = false;
                                scope.text = '';
                           }else {
                                 scope.flag = true;
                                 scope.text = '当前值设置不在最小值和最大值之间，请重新设置!';
                           }

                       }
                     }
                     scope.$apply();
                   })

               break;
               case 'datetime':
                     element.datetimepicker('remove');
                     element.datetimepicker({
                       format: 'yyyy-mm-dd hh:ii',
                       todayHighlight: true,
                       language: "zh-CN",
                     })
                     .on('changeDate', function(e){
                       var datetimeFormat = scope.dateformat +' '+ scope.timeformat
                       console.log(datetimeFormat)

                       var momentFormat = formatDatetime('datetime', datetimeFormat);
                       console.log(momentFormat);

                       var result = new moment(e.date).format(momentFormat);
                       //切记：要手动设置关闭，在重新设置值，前后顺序不要变
                       element.datetimepicker('hide')
                       // ctrl.$setViewValue(result); //?
                       scope.cur = result;
                       // 比较判断
                       console.log(scope.cur)
                       // 最小值
                       if(!attr.min) {
                         console.log('起始日期进来了')
                         if(scope.max) {
                           var flag = moment(scope.max).isBefore(result);
                           if(momentFormat.indexOf('YYYY年MM月DD日') !== -1){
                             flag = !flag
                           }
                           console.log(flag)
                           if(flag){
                             scope.flag = true;
                             scope.text = '起始日期比结束日期晚，请重新设置！';
                           }else {
                             scope.flag = false;
                             scope.text = '';
                           }
                         }
                       }else if(!attr.max){
                         // 最大值设置
                         console.log('结束日期进来了')
                         if(scope.min){
                           var flag = moment(scope.min).isBefore(result);
                           if(momentFormat.indexOf('YYYY年MM月DD日') !== -1){
                             flag = !flag
                           }
                           console.log(flag);
                           if(!flag){
                             scope.flag = true;
                             scope.text = '起始日期比结束日期晚，请重新设置！';
                           }else {
                             scope.flag = false;
                             scope.text = '';
                           }
                         }
                       }else {
                         // 初始值设置
                         console.log('初始值进来了')
                         console.log(scope.min);
                         console.log(scope.max)
                         console.log(scope.min && scope.max)
                         if(scope.min || scope.max){
                            var flag = moment(result).isBetween(scope.min, scope.max);
                               console.log(flag)
                            if(momentFormat.indexOf('YYYY年MM月DD日') !== -1){
                                 flag = !flag;
                            }
                            if(flag){
                                 scope.flag = false;
                                 scope.text = '';
                            }else {
                                  scope.flag = true;
                                  scope.text = '当前值设置不在最小值和最大值之间，请重新设置!';
                            }

                         }
                       }
                       scope.$apply();
                     })
               break;
               case 'time':
                   element.datetimepicker('remove');
                   element.datetimepicker({
                     format: 'hh:ii',
                    language: "zh-CN",
                    minView: 0,
                    todayHighlight: false,
                    startView: 0, // 0 代表小时视图
                    minuteStep: 5 //设置显示小时的步长
                   })
                   .on('changeDate', function(e){

                     var momentFormat = formatDatetime('time', scope.timeformat);
                     var result = new moment(e.date).format(momentFormat);
                     //切记：要手动设置关闭，在重新设置值，前后顺序不要变
                     element.datetimepicker('hide')
                     // ctrl.$setViewValue(result); //?
                     scope.cur = result;
                     // 比较判断
                     console.log('当前日期')
                     console.log(scope.cur)
                     var compareCurSecond = getSecondsByTime(scope.cur);
                     // 最小值
                     if(!attr.min) {
                       console.log('起始日期进来了')
                       if(scope.max) {
                         var compareMaxSecond = getSecondsByTime(scope.max)
                        var flag = compareMaxSecond - compareCurSecond;
                         if(flag < 0){
                           scope.flag = true;
                           scope.text = '起始日期比结束日期晚，请重新设置！';
                         }else {
                           scope.flag = false;
                           scope.text = '';
                         }
                       }
                     }else if(!attr.max){
                       // 最大值设置
                       console.log('结束日期进来了')
                       if(scope.min){
                         var compareMinSecond = getSecondsByTime(scope.min)
                         var flag = compareCurSecond - compareMinSecond;
                         if(flag < 0){
                           scope.flag = true;
                           scope.text = '起始日期比结束日期晚，请重新设置！';
                         }else {
                           scope.flag = false;
                           scope.text = '';
                         }
                       }
                     }else {
                       // 初始值设置
                       console.log('初始值进来了')
                       console.log(scope.min);
                       console.log(scope.max)
                       console.log(scope.min && scope.max)
                       if(scope.min || scope.max){
                          var compareMaxSecond = getSecondsByTime(scope.max);
                          var compareMinSecond = getSecondsByTime(scope.min)
                          if(compareMaxSecond - compareCurSecond > 0 && compareCurSecond - compareMinSecond > 0){
                               scope.flag = false;
                               scope.text = '';
                          }else {
                                scope.flag = true;
                                scope.text = '当前值设置不在最小值和最大值之间，请重新设置!';
                          }
                       }
                     }
                     scope.$apply();
                   })
               break;
             }

           }
         }
       })

       /**
        * 功能：格式化时间
        * type:日期时间类型，取值：date、datetime、time
        * formattime: 时间显示的格式
        *
        */
      function formatDatetime(type, formattime){
        var result = '';
        switch (type) {
          case 'date':
              var momentFormat = '';
              // // 转化成moment支持的格式化格式
              switch (formattime) {
                case 'yyyy-mm-dd':
                  momentFormat = 'YYYY-MM-DD'
                  break;
                  case 'yyyy年mm月dd日':
                  momentFormat = 'YYYY年MM月DD日';
                  break;
                  case 'yyyy/mm/dd':
                  momentFormat = 'YYYY/MM/DD'
                  break;
              }
              // result = new moment(datetime).format(momentFormat);
          break;
          case 'datetime':
              var momentFormat = '';
              // 转化成moment支持的格式化格式
              switch (formattime) {
                case 'yyyy-mm-dd hh:ii':
                    momentFormat = 'YYYY-MM-DD hh:mm'
                  break;
                case 'yyyy-mm-dd hh:ii:ss':
                    momentFormat = 'YYYY-MM-DD hh:mm:ss'
                break;
                case 'yyyy-mm-dd HH:ii':
                  momentFormat = 'YYYY-MM-DD HH:mm'
                break;
                case 'yyyy-mm-dd HH:ii:ss':
                    momentFormat = 'YYYY-MM-DD HH:mm:ss'
                break;

                case 'yyyy/mm/dd hh:ii':
                console.log('haha')
                    momentFormat = 'YYYY/MM/DD hh:mm'
                  break;
                case 'yyyy/mm/dd hh:ii:ss':
                    momentFormat = 'YYYY/MM/DD hh:mm:ss'
                break;
                case 'yyyy/mm/dd HH:ii':

                  momentFormat = 'YYYY/MM/DD HH:mm'
                break;
                case 'yyyy/mm/dd HH:ii:ss':
                    momentFormat = 'YYYY/MM/DD HH:mm:ss'
                break;


                case 'yyyy年mm月dd日 hh:ii':
                    momentFormat = 'YYYY年MM月DD hh:mm'
                  break;
                case 'yyyy年mm月dd日 hh:ii:ss':
                    momentFormat = 'YYYY年MM月DD hh:mm:ss'
                break;
                case 'yyyy年mm月dd日 HH:ii':
                  momentFormat = 'YYYY年MM月DD HH:mm'
                break;
                case 'yyyy年mm月dd日 HH:ii:ss':
                    momentFormat = 'YYYY年MM月DD HH:mm:ss'
                break;
              }
              // result = new moment(datetime).format(momentFormat);
          break;
          case 'time':
            var momentFormat = '';
            // 转化成moment支持的格式化格式
            switch (formattime) {
              case 'hh:ii':
                  momentFormat = 'hh:mm'
                break;
                case 'hh:ii:ss':
                momentFormat = 'hh:mm:ss';
                break;
                case 'HH::ii':
                momentFormat = 'HH:mm'
                break;
                case 'HH:ii:ss':
                momentFormat = 'HH:mm:ss'
                break;
            }
            // result = new moment(datetime).format(momentFormat);
          break;

        }
        return momentFormat;
      }//formatDatetime
      /**
      * 功能： 转化为秒
      * time: 时间, 取值： hh:mm  hh:mm:ss  HH:mm  HH:mm:ss
      */
      function getSecondsByTime(time){
        var timeArr = time.split(':'), totalSecond = 0, h = 0, m = 0, s = 0;
        if(timeArr.length === 2){
          timeArr.unshift(0);
        }
        for(var i = 0, len = timeArr.length; i<len; i++){
          var cur = timeArr[i];
          switch (i) {
            case 0:
              h = cur * 3600;
            break;
            case 1:
              m = cur * 60;
            break;
            case 2:
              s = cur - 0;
            break;
          }
        }
        totalSecond = h + m + s;
        return totalSecond;
      }
