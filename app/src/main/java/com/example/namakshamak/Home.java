package com.example.namakshamak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class Home extends AppCompatActivity {
    EditText searchtext;
    Button searchbt;
    //for circle menu
    CircleMenu circleMenu;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchtext=findViewById(R.id.searchtext);

        //assigning the instance to their respective ..
        circleMenu = findViewById(R.id.circle_menu);
        constraintLayout = findViewById(R.id.constraint_layout);
        circleMenu.setMainMenu(Color.parseColor("#DB1D93"),R.mipmap.list,R.mipmap.multiply)
                .addSubMenu(Color.parseColor("#E61DDB"),R.mipmap.home)
                .addSubMenu(Color.parseColor("#3B20C9"),R.mipmap.add)
                .addSubMenu(Color.parseColor("#fff591"),R.mipmap.account)
                .addSubMenu(Color.parseColor("#B7241D"),R.mipmap.gear)
                .addSubMenu(Color.parseColor("#397D20"),R.mipmap.logout)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        switch (index){
                            case 0:
                                Toast.makeText(Home.this, "Home", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                Intent intent = new Intent(Home.this, Home.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Toast.makeText(Home.this, "Add recipe will be available soon", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                break;
                            case 2:
                                Toast.makeText(Home.this, "Your profile is being scanned by CIA", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                break;
                            case 3:
                                Toast.makeText(Home.this, "Settings is currently on vacation", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                break;
                            case 4:
                                Toast.makeText(Home.this, "You have been logged out bye bye", Toast.LENGTH_SHORT).show();
                                constraintLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                FirebaseAuth.getInstance().signOut();
                                Intent intent2 = new Intent(Home.this,MainActivity.class);
                                startActivity(intent2);
                                break;
                        }
                    }
                });

    }


    public void gotocatbur(View view) {
        Intent iburr= new Intent(Home.this,cat_burr.class);
        startActivity(iburr);
    }

    public void gotocatnoodle(View view) {
        Intent inoo= new Intent(Home.this,cat_noodles.class);
        startActivity(inoo);
    }

    public void gotosalad(View view) {
        Intent isala = new Intent(Home.this,cat_salaa.class);
        startActivity(isala);
    }

    public void gotosub(View view) {
        Intent isub = new Intent(Home.this,cat_sub.class);
        startActivity(isub);
    }

    public void gotopan(View view) {
        Intent ipan= new Intent(Home.this,cat_paneer.class);
        startActivity(ipan);
    }

    public void gotosearch(View view) {
        String searchline = searchtext.getText().toString();
        if (searchline.isEmpty()) {
            Toast.makeText(Home.this, "Please Enter Something!", Toast.LENGTH_SHORT).show();
        } else {
            Intent isearch = new Intent(Home.this,Search.class);
            isearch.putExtra("searchline", searchline);
            startActivity(isearch);
        }
    }

    public void gotochickencurry(View view) {
        Intent intent12= new Intent(Home.this,detailed.class);
        intent12.putExtra("data1","Chichken Curry");
        intent12.putExtra("data2","9 teaspoons vegetable oil, divided" +
                "4 onions, chopped," +
                "2 green chile peppers, chopped," +
                "1 teaspoon cumin seeds," +
                "2 bay leaves," +
                "1 teaspoon ginger-garlic paste," +
                "1 teaspoon garam masala," +
                "1 teaspoon ground red chile pepper," +
                "1 teaspoon ground coriander," +
                "½ teaspoon ground turmeric," +
                "5 tomatoes, chopped," +
                "2 ¼ pounds boneless chicken thighs," +
                "salt to taste," +
                "3 cups water," +
                "¼ bunch fresh cilantro, finely chopped");
        intent12.putExtra("images",R.drawable.chickencurryrecipe);
        intent12.putExtra("data3",getResources().getString(R.string.recchickencurry));
        startActivity(intent12);
    }

    public void gotoidli(View view) {
        Intent intent12= new Intent(Home.this,detailed.class);
        intent12.putExtra("data1","Idli");
        intent12.putExtra("data2","1 cup regular rice + 1 cup parboiled rice or 2 cups idli rice or 2 cups parboiled rice\n" +
                "½ cup whole or split urad dal – 120 grams whole or split urad dal (husked black gram)\n" +
                "¼ cup thick poha – 20 grams (flattened rice)\n" +
                "¼ teaspoon fenugreek seeds (methi seeds)\n" +
                "2 cups water – for soaking rice\n" +
                "1 cup water – for soaking urad dal\n" +
                "½ cup water – for grinding urad dal or add as required\n" +
                "¾ to 1 cup water – for grinding rice or add as required\n" +
                "1 teaspoon rock salt (edible and food grade) or sea salt\n" +
                "oil – as required to apply to the idli moulds\n" +
                "2 to 2.5 cups water – for steaming idli");
        intent12.putExtra("images",R.drawable.idlirec);
        intent12.putExtra("data3",getResources().getString(R.string.recidli));
        startActivity(intent12);
    }

    public void gotokebbur(View view) {
        Intent intent12= new Intent(Home.this,detailed.class);
        intent12.putExtra("data1","Kebab Burger");
        intent12.putExtra("data2","2 tbsp fat-free yogurt\n" +
                "1 tbsp mayonnaise\n" +
                "1 small garlic clove , grated\n" +
                "½ tbsp vegetable oil\n" +
                "2 lamb burgers\n" +
                "2 sesame seed burger buns\n" +
                "1 tomato , sliced\n" +
                "20g gherkins , sliced\n" +
                "1 red chilli , finely sliced\n" +
                "leaves of 1 Baby Gem lettuce");
        intent12.putExtra("images",R.drawable.burgernain);
        intent12.putExtra("data3",getResources().getString(R.string.reckebabburbur));
        startActivity(intent12);
    }

    public void gotoramen(View view) {
        Intent intent12= new Intent(Home.this,detailed.class);
        intent12.putExtra("data1","Ramen");
        intent12.putExtra("data2","4 cups vegetable broth\n" +
                "4 cups water\n" +
                "1 tablespoon soy sauce\n" +
                "1 tablespoon sesame oil\n" +
                "1 tablespoon ground ginger\n" +
                "1 tablespoon Sriracha hot sauce\n" +
                "9 ounces soba noodles");
        intent12.putExtra("images",R.drawable.ramenrec);
        intent12.putExtra("data3","1. Combine broth, water, soy sauce, sesame oil, ginger, and hot sauce in a pot\n" +
                "2. bring to a boil. Add noodles to boiling broth mixture and cook until noodles are tender yet firm to the bite, 5 to 7 minutes. \n" +
                "3. Transfer noodles to serving bowls and top with desired amount of broth.");
        startActivity(intent12);
    }

    public void gotosal(View view) {
        Intent intent12= new Intent(Home.this,detailed.class);
        intent12.putExtra("data1","Spring Salad");
        intent12.putExtra("data2","12 slices bacon\n" +
                "2 heads fresh broccoli, florets only\n" +
                "1 cup chopped celery\n" +
                "½ cup chopped green onions\n" +
                "1 cup seedless green grapes\n" +
                "1 cup seedless red grapes\n" +
                "½ cup raisins\n" +
                "½ cup blanched slivered almonds\n" +
                "1 cup mayonnaise\n" +
                "1 tablespoon white wine vinegar\n" +
                "¼ cup white sugar");
        intent12.putExtra("images",R.drawable.salad1);
        intent12.putExtra("data3","1. Place bacon in a large, deep skillet. Cook over medium high heat until evenly brown. Drain, crumble and set aside.\n" +
                "\n" +
                "2. In a large salad bowl, toss together the bacon, broccoli, celery, green onions, green grapes, red grapes, raisins and almonds.\n" +
                "\n" +
                "3. Whisk together the mayonnaise, vinegar and sugar. Pour dressing over salad and toss to coat. Refrigerate until ready to serve.");
        startActivity(intent12);
    }

    public void gotobiryani(View view) {
        Intent intent12= new Intent(Home.this,detailed.class);
        intent12.putExtra("data1","Hyderabad Dum Biryani");
        intent12.putExtra("data2","3 ½ cups water\n" +
                "2 ⅓ cups basmati rice\n" +
                "4 bay leaves, divided\n" +
                "½ cup warm milk\n" +
                "1 pinch saffron threads\n" +
                "¼ cup ghee (clarified butter), divided\n" +
                "2 onions, thinly sliced\n" +
                "2 green chile peppers, chopped");
        intent12.putExtra("images",R.drawable.biryanirec);
        intent12.putExtra("data3",getResources().getString(R.string.recbiryanirec));
        startActivity(intent12);
    }

}