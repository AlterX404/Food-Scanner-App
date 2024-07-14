package app.suhasdissa.foode.backend.database;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.Override;
import java.lang.SuppressWarnings;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
class BarcodeDatabase_AutoMigration_1_2_Impl extends Migration {
  public BarcodeDatabase_AutoMigration_1_2_Impl() {
    super(1, 2);
  }

  @Override
  public void migrate(@NonNull final SupportSQLiteDatabase database) {
    database.execSQL("ALTER TABLE `barcode_history` ADD COLUMN `favourite` INTEGER NOT NULL DEFAULT 0");
  }
}
