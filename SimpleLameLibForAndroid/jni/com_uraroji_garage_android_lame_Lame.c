#include "com_uraroji_garage_android_lame_Encoder.h"
#include "simple_lame_lib.h"

JNIEXPORT void JNICALL Java_com_uraroji_garage_android_lame_Lame_log
  (JNIEnv *env, jclass cls, jboolean on) {
	simple_lame_lib_log(on);
}
