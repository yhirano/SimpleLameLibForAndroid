#include <jni.h>
#include "lame.h"

#ifndef __SIMPLE_LAME_LIB_H__
#define __SIMPLE_LAME_LIB_H__

#ifdef __cplusplus
extern "C" {
#endif

lame_global_flags* simple_lame_lib_init(
		JNIEnv* env,
		jint inSamplerate, jint outChannel,
		jint outSamplerate, jint outBitrate, jint quality,
		jstring id3tagTitle, jstring id3tagArtist, jstring id3tagAlbum,
		jstring id3tagYear, jstring id3tagComment);

jint simple_lame_lib_encode(
		JNIEnv* env, lame_global_flags* glf, 
		jshortArray buffer_l, jshortArray buffer_r,
		jint samples, jbyteArray mp3buf);

jint simple_lame_lib_encodeBufferInterleaved(
		JNIEnv *env, lame_global_flags* glf, 
		jshortArray pcm, jint samples, jbyteArray mp3buf);

jint simple_lame_lib_flush(
		JNIEnv* env, lame_global_flags* glf, 
		jbyteArray mp3buf);

void simple_lame_lib_close(
		lame_global_flags* glf);

void simple_lame_lib_log(
		jboolean on);

#ifdef __cplusplus
}
#endif
#endif