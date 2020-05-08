# 
mvp模式基类

## How to ##

To get a Git project into your build:

### Step 1. Add the JitPack repository to your build file ###

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

### Step 2. Add the dependency ###

	dependencies {
	        implementation 'com.github.nangongyibin:Android_MVPBase:1.0.4'
	}


### step 3. need to add dependency ###

	//AutoDispose解决RxJava内存泄漏
    implementation 'com.uber.autodispose:autodispose:0.7.0'
    implementation 'com.uber.autodispose:autodispose-android:0.7.0'
    implementation 'com.uber.autodispose:autodispose-android-archcomponents:0.7.0'