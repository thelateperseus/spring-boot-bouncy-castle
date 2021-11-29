Spring Boot Bouncy Castle Issue
===============================

This sample application demonstrates the exception when using Bouncy Castle from a Spring Boot fat jar under Java 17.

To reproduce the problem:

```
gradlew assemble
java -jar build/libs/spring-boot-bouncy-castle-0.0.1-SNAPSHOT.jar
```

You should see the stacktrace below:

```
Exception in thread "main" java.lang.reflect.InvocationTargetException
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:88)
Caused by: java.lang.SecurityException: JCE cannot authenticate the provider BC
        at java.base/javax.crypto.Cipher.getInstance(Cipher.java:722)
        at java.base/javax.crypto.Cipher.getInstance(Cipher.java:642)
        at com.example.bctest.BctestApplication.main(BctestApplication.java:14)
        ... 8 more
Caused by: java.lang.IllegalStateException: zip file closed
        at java.base/java.util.zip.ZipFile.ensureOpen(ZipFile.java:831)
        at java.base/java.util.zip.ZipFile.getManifestName(ZipFile.java:1057)
        at java.base/java.util.zip.ZipFile$1.getManifestName(ZipFile.java:1100)
        at java.base/javax.crypto.JarVerifier.verifySingleJar(JarVerifier.java:461)
        at java.base/javax.crypto.JarVerifier.verifyJars(JarVerifier.java:317)
        at java.base/javax.crypto.JarVerifier.verify(JarVerifier.java:260)
        at java.base/javax.crypto.ProviderVerifier.verify(ProviderVerifier.java:130)
        at java.base/javax.crypto.JceSecurity.verifyProvider(JceSecurity.java:190)
        at java.base/javax.crypto.JceSecurity.getVerificationResult(JceSecurity.java:218)
        at java.base/javax.crypto.Cipher.getInstance(Cipher.java:718)
        ... 10 more
```