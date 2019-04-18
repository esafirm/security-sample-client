#include <jni.h>

JNIEXPORT jstring JNICALL
Java_security_sample_ApiCaller_getNativeKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "MTIzNDU=");
}