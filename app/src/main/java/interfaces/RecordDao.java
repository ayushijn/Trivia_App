package interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.triviaapp.activities.models.UserRecord;

import java.util.List;

@Dao
public interface RecordDao{

    @Query("SELECT * FROM UserRecord")
    List<UserRecord> getAll();

    @Insert
   public void insert(UserRecord userRecord);

    @Delete
    void delete(UserRecord userRecord);

    @Update
    void update(UserRecord userRecord);

}