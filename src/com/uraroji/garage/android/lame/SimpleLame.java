
package com.uraroji.garage.android.lame;

/**
 * LAME interface class
 */
public class SimpleLame {

    /**
     * Initialize LAME.
     * 
     * @param inSamplerate input sample rate in Hz.
     * @param outChannel number of channels in input stream.
     * @param outSamplerate output sample rate in Hz.
     * @param outBitrate brate compression ratio in KHz.
     */
    public static void init(int inSamplerate, int outChannel,
            int outSamplerate, int outBitrate) {
        init(inSamplerate, outChannel, outSamplerate, outBitrate, 7);
    }

    /**
     * Initialize LAME.
     * 
     * @param inSamplerate input sample rate in Hz.
     * @param outChannel number of channels in input stream.
     * @param outSamplerate output sample rate in Hz.
     * @param outBitrate brate compression ratio in KHz.
     * @param quality quality=0..9. 0=best (very slow). 9=worst.<br />
     *            recommended:<br />
     *            2 near-best quality, not too slow<br />
     *            5 good quality, fast<br />
     *            7 ok quality, really fast
     */
    public static void init(int inSamplerate, int outChannel,
            int outSamplerate, int outBitrate, int quality) {
        init(inSamplerate, outChannel, outSamplerate, outBitrate, quality,
                null, null, null, null, null);
    }

    /**
     * Initialize LAME.
     * 
     * @param inSamplerate input sample rate in Hz.
     * @param outChannel number of channels in input stream.
     * @param outSamplerate output sample rate in Hz.
     * @param outBitrate brate compression ratio in KHz.
     * @param quality quality=0..9. 0=best (very slow). 9=worst.<br />
     *            recommended:<br />
     *            2 near-best quality, not too slow<br />
     *            5 good quality, fast<br />
     *            7 ok quality, really fast
     * @param id3tagTitle ID3 Tag title.
     * @param id3tagArtist ID3 Tag artist.
     * @param id3tagAlbum ID3 Tag album.
     * @param id3tagYear ID3 Tag year.
     * @param id3tagComment ID3 Tag comment.
     */
    public native static void init(int inSamplerate, int outChannel,
            int outSamplerate, int outBitrate, int quality, String id3tagTitle,
            String id3tagArtist, String id3tagAlbum, String id3tagYear,
            String id3tagComment);

    /**
     * Encode buffer to mp3.
     * 
     * @param buffer_l PCM data for left channel.
     * @param buffer_r PCM data for right channel.
     * @param sambles number of samples per channel.
     * @param mp3buf result encoded MP3 stream. You must specified
     *            "7200 + (1.25 * samples)" length array.
     * @return number of bytes output in mp3buf. Can be 0.<br />
     *         -1: mp3buf was too small<br />
     *         -2: malloc() problem<br />
     *         -3: lame_init_params() not called<br />
     *         -4: psycho acoustic problems
     */
    public native static int encode(short[] buffer_l, short[] buffer_r,
            int samples, byte[] mp3buf);

    /**
     * Encode buffer L & R channel data interleaved to mp3.
     * 
     * @param pcm PCM data for left and right channel, interleaved.
     * @param sambles number of samples per channel. <strong>not</strong> number
     *            of samples in pcm[].
     * @param mp3buf result encoded MP3 stream. You must specified
     *            "7200 + (1.25 * samples)" length array.
     * @return number of bytes output in mp3buf. Can be 0.<br />
     *         -1: mp3buf was too small<br />
     *         -2: malloc() problem<br />
     *         -3: lame_init_params() not called<br />
     *         -4: psycho acoustic problems
     */
    public native static int encodeBufferInterleaved(short[] pcm, int samples,
            byte[] mp3buf);

    /**
     * Flush LAME buffer.
     * 
     * @param mp3buf result encoded MP3 stream. You must specified at least 7200
     *            bytes.
     * @return number of bytes output to mp3buf. Can be 0.
     */
    public native static int flush(byte[] mp3buf);

    /**
     * Close LAME.
     */
    public native static void close();

    /**
     * Display log.
     * 
     * @param on display log setting.
     */
    public native static void log(boolean on);
}
