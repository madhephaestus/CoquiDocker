

        OkHttpClient client = new OkHttpClient();

        String url = "http://[::1]:5002//api/tts?text=test%20the%20text%20to%20speech&speaker_id=p376&style_wav=&language_id="; // Replace with your URL

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            // Handle the response as needed
            String responseBody = response.body().string();
            System.out.println("Response Body: " + responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }