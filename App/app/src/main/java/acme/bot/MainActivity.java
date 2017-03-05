package acme.bot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import acme.bot.models.SearchCriteria;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.Contacts.SettingsColumns.KEY;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Button mButtonSend;
    private EditText mEditTextMessage;
    private ImageView mImageView;
    private ChatMessageAdapter mAdapter;
    private SearchResult searchResult;

    public static final String URL = "https://82b8d22a.ngrok.io/myapp/";
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mButtonSend = (Button) findViewById(R.id.btn_send);
        mEditTextMessage = (EditText) findViewById(R.id.et_message); //text field for the user input
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);

        searchResult = new SearchResult("empty");

//code for sending the message
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditTextMessage.getText().toString();
                sendMessage(message);
                mEditTextMessage.setText("");
                mListView.setSelection(mAdapter.getCount() - 1);
            }
        });
    }

    private void sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(message, true, false);
        mAdapter.add(chatMessage);

        fetchData(chatMessage.getContent());
        //respond as Helloworld
        // message send by the bot
    }

    private void mimicOtherMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(message, false, false);
        mAdapter.add(chatMessage);
    }

    private void sendMessage() {
        ChatMessage chatMessage = new ChatMessage(null, true, true);
        mAdapter.add(chatMessage);

        mimicOtherMessage();
    }

    private void mimicOtherMessage() {
        ChatMessage chatMessage = new ChatMessage(null, false, true);
        mAdapter.add(chatMessage);
    }


    private void fetchData(String searchCriteria) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchCriteria body = new SearchCriteria();
        body.setText(searchCriteria);
        RESTInterface rest = retrofit.create(RESTInterface.class);
        Call<SearchCriteria> call = rest.getSearchResults(body);
        call.enqueue(new Callback<SearchCriteria>() {
            @Override
            public void onResponse(Call<SearchCriteria> call, Response<SearchCriteria> response) {
                //searchResult = response.body();
                String result = checkResponse(response.body());
                mimicOtherMessage("response: " + result);
            }

            @Override
            public void onFailure(Call<SearchCriteria> call, Throwable t) {
                Log.i("error", t.getMessage());
            }
        });
    }

    private String checkResponse(SearchCriteria body) {
        String response = "";
        if(!body.getComplete()) {
            response += "You can filter your results by setting the following: \n";
            if(body.getPrice() == null) {
                response += "Price\n";
            } if (body.getEcommerce() == null) {
                response += "E-Commerce\n";
            } if(body.getCritera() == null) {
                response += "Criteria\n";
            }
        }
        return response;
    }
}

