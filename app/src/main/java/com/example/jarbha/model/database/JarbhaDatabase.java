package com.example.jarbha.model.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.jarbha.R;
import com.example.jarbha.model.dao.CategoryDao;
import com.example.jarbha.model.dao.CategoryQuestionDao;
import com.example.jarbha.model.dao.QuestionDao;
import com.example.jarbha.model.entity.CategoryEntity;
import com.example.jarbha.model.entity.CategoryQuestionEntity;
import com.example.jarbha.model.entity.QuestionEntity;

@Database(entities = {CategoryEntity.class, QuestionEntity.class, CategoryQuestionEntity.class}, version = 1)
public abstract class JarbhaDatabase extends RoomDatabase {

    //region Database
    private static JarbhaDatabase instance;

    private static RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }


    };

    public static JarbhaDatabase getInstance(Context context) {
        if (instance == null)
            //Create instance of database
            instance = Room.databaseBuilder(context.getApplicationContext(), JarbhaDatabase.class, "jarbha_data_base")
                    //If i change something in database (tables) make the old applications destroy them database and rebuild it
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();

        return instance;
    }
    //endregion

    //region Dao
    public abstract CategoryDao categoryDao();

    public abstract QuestionDao questionDao();

    public abstract CategoryQuestionDao categoryQuestionDao();
    //endregion

    //region Async task
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private CategoryDao categoryDao;
        private QuestionDao questionDao;

        public PopulateDbAsyncTask(JarbhaDatabase jarbhaDatabase) {
            categoryDao = jarbhaDatabase.categoryDao();
            questionDao = jarbhaDatabase.questionDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.insert(new CategoryEntity("Sport", R.drawable.icon_sport,R.drawable.card_yellow));
            categoryDao.insert(new CategoryEntity("Sciences", R.drawable.icon_science,R.drawable.card_green));
            categoryDao.insert(new CategoryEntity("Gaming", R.drawable.icon_gaming,R.drawable.card_blue));
            categoryDao.insert(new CategoryEntity("Music", R.drawable.icon_music,R.drawable.card_orange));
            categoryDao.insert(new CategoryEntity("Movie", R.drawable.icon_youtube,R.drawable.card_red));
            categoryDao.insert(new CategoryEntity("Think", R.drawable.icon_calculate,R.drawable.card_neal));


            //todo dialog
//            questionDao.insert(new QuestionEntity("من هو افضل لاعب في العالم؟","ميسي" , "يشسي", "سشيسشي", "سشيشسي", false, "رياضة"));
            return null;
        }
    }
    //endregion
}
