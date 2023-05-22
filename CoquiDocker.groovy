import java.nio.charset.StandardCharsets

import javax.media.format.AudioFormat
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

import com.neuronrobotics.bowlerstudio.AudioPlayer
import com.neuronrobotics.bowlerstudio.BowlerStudio
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response

import okio.BufferedSource
import com.squareup.okhttp.ResponseBody

OkHttpClient client = new OkHttpClient();

String content =URLEncoder.encode(" Spirit World! Answer Me!  ".trim(),StandardCharsets.UTF_8.toString()).replace("+", "%20")

String url = "http://[::1]:5002//api/tts?text="+content+"&style_wav=&language_id=HTTP/1.1"; // Replace with your URL

Request request = new Request.Builder()
		.url(url)
		.get()
		.build();

try {
	Response response = client.newCall(request).execute()
	// Handle the response as needed
	String responseBody = response.message()
	InputStream is = response.body().byteStream();	
	List<String> len = response.headers("Content-Length")
	List<String> type = response.headers("Content-Type")
	println len
	println type
	tts = new AudioPlayer();
	audio=AudioSystem.getAudioInputStream(new BufferedInputStream(is))
	tts.setAudio(audio);

	tts.run()
	
	System.out.println("Response Body: " + responseBody);
} catch (IOException e) {
	BowlerStudio.printStackTrace(e);
}