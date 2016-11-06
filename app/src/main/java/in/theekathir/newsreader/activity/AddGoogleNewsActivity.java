/**
 * Flym
 * <p/>
 * Copyright (c) 2012-2015 Frederic Julian
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package in.theekathir.newsreader.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

import in.theekathir.newsreader.R;
import in.theekathir.newsreader.provider.FeedDataContentProvider;
import in.theekathir.newsreader.utils.UiUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class AddGoogleNewsActivity extends BaseActivity {

    /*private static final int[] TOPIC_NAME = new int[]{R.string.google_news_top_stories, R.string.google_news_world, R.string.google_news_business,
            R.string.google_news_technology, R.string.google_news_entertainment, R.string.google_news_sports, R.string.google_news_science, R.string.google_news_health};*/

    private static final int[] TOPIC_NAME = new int[]{R.string.politics, R.string.editor_picks, R.string.srilanka, R.string.international, R.string.opinion, R.string.article, R.string.cartoon, R.string.santhegam_samikannu, R.string.editorial, R.string.interview, R.string.letter_to_editor, R.string.education, R.string.cinema, R.string.specials, R.string.science_technology, R.string.literature, R.string.computer, R.string.books, R.string.economics, R.string.sports, R.string.info, R.string.nation, R.string.technology, R.string.court, R.string.facebook_ride, R.string.general, R.string.medicine, R.string.state, R.string.assam, R.string.andaman, R.string.haryana, R.string.arunachalpradesh, R.string.andhrapradesh, R.string.himachal, R.string.uttarakhand, R.string.uttarpradesh, R.string.odisha, R.string.karnataka, R.string.bengaluru, R.string.gujarat, R.string.kerala, R.string.goa, R.string.chandigarh, R.string.chhattisgarh, R.string.sikkim, R.string.jammuandkashmir, R.string.jharkhand, R.string.tamilnadu, R.string.chennai, R.string.dadra, R.string.damananddiu, R.string.tripura, R.string.delhi, R.string.telangana, R.string.nagaland, R.string.punjab, R.string.bihar, R.string.puducherry, R.string.maharashtra, R.string.mumbai, R.string.manipur, R.string.madhyapradesh, R.string.mizoram, R.string.meghalaya, R.string.westbengal, R.string.rajasthan, R.string.lakshadweep, R.string.districts, R.string.ariyalur, R.string.ramanathapuram, R.string.erode, R.string.cuddalore, R.string.kanyakumari, R.string.karur, R.string.kanchipuram, R.string.krishnagiri, R.string.coimbatore, R.string.sivaganga, R.string.salem, R.string.thanjavur, R.string.dharmapuri, R.string.dindigul, R.string.trichy, R.string.tirunelveli, R.string.tirupur, R.string.tiruvannamalai, R.string.tiruvallur, R.string.tiruvarur, R.string.thoothukudi, R.string.theni, R.string.nagapattinam, R.string.namakkal, R.string.nilgiris, R.string.pudukkottai, R.string.perambalur, R.string.pollachi, R.string.madurai, R.string.virudhunagar, R.string.viluppuram, R.string.vellore, R.string.business, R.string.election, R.string.whatsapp_ride, R.string.archive};

//    private static final String[] TOPIC_CODES = new String[]{null, "w", "b", "t", "e", "s", "snc", "m"};
    private static final String[] TOPIC_CODES = new String[]{"politics", "editor-picks", "srilanka", "international", "opinion", "article", "cartoon", "santhegam-samikannu", "editorial", "interview", "letter-to-editor", "education", "cinema", "specials", "science-technology", "literature", "computer", "books", "economics", "sports", "info", "nation", "technology", "court", "facebook_ride", "general", "medicine", "state", "assam", "andaman", "haryana", "arunachalpradesh", "andhrapradesh", "himachal", "uttarakhand", "uttarpradesh", "odisha", "karnataka", "bengaluru", "gujarat", "kerala", "goa", "chandigarh", "chhattisgarh", "sikkim", "jammuandkashmir", "jharkhand", "tamilnadu", "chennai", "dadra", "damananddiu", "tripura", "delhi", "telangana", "nagaland", "punjab", "bihar", "puducherry", "maharashtra", "mumbai", "manipur", "madhyapradesh", "mizoram", "meghalaya", "westbengal", "rajasthan", "lakshadweep", "districts", "ariyalur", "ramanathapuram", "erode", "cuddalore", "kanyakumari", "karur", "kanchipuram", "krishnagiri", "coimbatore", "sivaganga", "salem", "thanjavur", "dharmapuri", "dindigul", "trichy", "tirunelveli", "tirupur", "tiruvannamalai", "tiruvallur", "tiruvarur", "thoothukudi", "theni", "nagapattinam", "namakkal", "nilgiris", "pudukkottai", "perambalur", "pollachi", "madurai", "virudhunagar", "viluppuram", "vellore", "business", "election", "whatsapp_ride", "archive"};

    /*private static final int[] CB_IDS = new int[]{R.id.cb_top_stories, R.id.cb_world, R.id.cb_business, R.id.cb_technology, R.id.cb_entertainment,
            R.id.cb_sports, R.id.cb_science, R.id.cb_health};*/
    private static final int[] CB_IDS = new int[]{R.id.politics, R.id.editor_picks, R.id.srilanka, R.id.international, R.id.opinion, R.id.article, R.id.cartoon, R.id.santhegam_samikannu, R.id.editorial, R.id.interview, R.id.letter_to_editor, R.id.education, R.id.cinema, R.id.specials, R.id.science_technology, R.id.literature, R.id.computer, R.id.books, R.id.economics, R.id.sports, R.id.info, R.id.nation, R.id.technology, R.id.court, R.id.facebook_ride, R.id.general, R.id.medicine, R.id.state, R.id.assam, R.id.andaman, R.id.haryana, R.id.arunachalpradesh, R.id.andhrapradesh, R.id.himachal, R.id.uttarakhand, R.id.uttarpradesh, R.id.odisha, R.id.karnataka, R.id.bengaluru, R.id.gujarat, R.id.kerala, R.id.goa, R.id.chandigarh, R.id.chhattisgarh, R.id.sikkim, R.id.jammuandkashmir, R.id.jharkhand, R.id.tamilnadu, R.id.chennai, R.id.dadra, R.id.damananddiu, R.id.tripura, R.id.delhi, R.id.telangana, R.id.nagaland, R.id.punjab, R.id.bihar, R.id.puducherry, R.id.maharashtra, R.id.mumbai, R.id.manipur, R.id.madhyapradesh, R.id.mizoram, R.id.meghalaya, R.id.westbengal, R.id.rajasthan, R.id.lakshadweep, R.id.districts, R.id.ariyalur, R.id.ramanathapuram, R.id.erode, R.id.cuddalore, R.id.kanyakumari, R.id.karur, R.id.kanchipuram, R.id.krishnagiri, R.id.coimbatore, R.id.sivaganga, R.id.salem, R.id.thanjavur, R.id.dharmapuri, R.id.dindigul, R.id.trichy, R.id.tirunelveli, R.id.tirupur, R.id.tiruvannamalai, R.id.tiruvallur, R.id.tiruvarur, R.id.thoothukudi, R.id.theni, R.id.nagapattinam, R.id.namakkal, R.id.nilgiris, R.id.pudukkottai, R.id.perambalur, R.id.pollachi, R.id.madurai, R.id.virudhunagar, R.id.viluppuram, R.id.vellore, R.id.business, R.id.election, R.id.whatsapp_ride, R.id.archive};

    private EditText mCustomTopicEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UiUtils.setPreferenceTheme(this);
        super.onCreate(savedInstanceState);

        setResult(RESULT_CANCELED);

        setContentView(R.layout.activity_add_google_news);
//        mCustomTopicEditText = (EditText) findViewById(R.id.google_news_custom_topic);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.google_news, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_validate:
                for (int topic = 0; topic < TOPIC_NAME.length; topic++) {
                    if (((CheckBox) findViewById(CB_IDS[topic])).isChecked() && TOPIC_CODES[topic] != null) {
//                        String url = "http://news.google.com/news?hl=" + Locale.getDefault().getLanguage() + "&output=rss&topic=" + TOPIC_CODES[topic];
                        String url = "http://theekkathir.in/topics/" + TOPIC_CODES[topic] + "/feed";
                        FeedDataContentProvider.addFeed(this, url, getString(TOPIC_NAME[topic]), true);
                    }
                }

//                String custom_topic = mCustomTopicEditText.getText().toString();
//                if(!custom_topic.isEmpty())
//                {
//                    try {
//                        String url = "http://news.google.com/news?hl=" + Locale.getDefault().getLanguage() + "&output=rss&q=" + URLEncoder.encode(custom_topic, "UTF-8");
//                        FeedDataContentProvider.addFeed(this, url, custom_topic, true);
//                    } catch (UnsupportedEncodingException ignored) {
//                    }
//                }

                setResult(RESULT_OK);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

