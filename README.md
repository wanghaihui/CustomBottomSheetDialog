# CustomBottomSheetDialog
利用BottomSheetDialog实现仿Android版QQ的底部弹出对话框

## 效果图
![](https://github.com/ygeng/CustomBottomSheetDialog/raw/master/preview/preview.gif)

## 依赖
### step1. Add it in your root build.gradle at the end of repositories:
```java
   allprojects {
      repositories {
          ...
          maven { url 'https://jitpack.io' }
      }
   }
```
### step2. Add the dependency in your module build.gradle:
```java
   dependencies {
      compile 'com.github.ygeng:CustomBottomSheetDialog:1.0.0'
   }
```

## 使用
```java
BottomSheetDialogUtil.init(context,
                        new String[]{"拍照", "从相册选取"},
                        new OnItemClickListener() {
                            @Override
                            public void onItemClick(View v, int position) {
                                Toast.makeText(context, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
```
