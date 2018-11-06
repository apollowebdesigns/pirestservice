## Loading up Java

```
git clone https://github.com/apollowebdesigns/pirestservice.git
```

### Compiling Native Java code with JNI

This stuff is very hard and fiddly to get right, here are some instructions for the
raspberry pi!!!

For a HelloWorld example create

```
javac HelloWorld.java
```

Then, create a headers file for the C program, so the Java program can hook into it.

```
javah -jni HelloWorld
```

Create the C file with desired code in -

For a Hello World example, use this file

```
 #include <jni.h>
 #include <stdio.h>
 #include "HelloWorld.h"

 JNIEXPORT void JNICALL
 Java_HelloWorld_print(JNIEnv *env, jobject obj)
 {
     printf("Hello World!\n");
     return;
 }
```

Create a shared library for the C code to be accessed by Java

```
gcc -shared -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include/linux  HelloWorld.c -o libHelloWorld.so
```

When in the current directory of the running file run for the HelloWorld example

```
java -Djava.library.path=. HelloWorld
```

Here is a website for more info

https://www.java-tips.org/other-api-tips-100035/148-jni/1378-simple-example-of-using-the-java-native-interface.html
