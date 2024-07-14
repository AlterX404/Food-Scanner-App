package app.suhasdissa.foode.backend.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import app.suhasdissa.foode.backend.database.dao.BarcodeHistoryDao;
import app.suhasdissa.foode.backend.database.dao.BarcodeHistoryDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BarcodeDatabase_Impl extends BarcodeDatabase {
  private volatile BarcodeHistoryDao _barcodeHistoryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `barcode_history` (`barcode` TEXT NOT NULL, `title` TEXT NOT NULL, `image_url` TEXT NOT NULL, `favourite` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`barcode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '23ee35737ddcb4477d20d77b0b5bd35b')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `barcode_history`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBarcodeHistory = new HashMap<String, TableInfo.Column>(4);
        _columnsBarcodeHistory.put("barcode", new TableInfo.Column("barcode", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarcodeHistory.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarcodeHistory.put("image_url", new TableInfo.Column("image_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarcodeHistory.put("favourite", new TableInfo.Column("favourite", "INTEGER", true, 0, "0", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBarcodeHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBarcodeHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBarcodeHistory = new TableInfo("barcode_history", _columnsBarcodeHistory, _foreignKeysBarcodeHistory, _indicesBarcodeHistory);
        final TableInfo _existingBarcodeHistory = TableInfo.read(_db, "barcode_history");
        if (! _infoBarcodeHistory.equals(_existingBarcodeHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "barcode_history(app.suhasdissa.foode.backend.database.entities.BarcodeEntity).\n"
                  + " Expected:\n" + _infoBarcodeHistory + "\n"
                  + " Found:\n" + _existingBarcodeHistory);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "23ee35737ddcb4477d20d77b0b5bd35b", "4efd20c2534890467d14fe5e267b3aa5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "barcode_history");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `barcode_history`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(BarcodeHistoryDao.class, BarcodeHistoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList(new BarcodeDatabase_AutoMigration_1_2_Impl());
  }

  @Override
  public BarcodeHistoryDao barcodeHistoryDao() {
    if (_barcodeHistoryDao != null) {
      return _barcodeHistoryDao;
    } else {
      synchronized(this) {
        if(_barcodeHistoryDao == null) {
          _barcodeHistoryDao = new BarcodeHistoryDao_Impl(this);
        }
        return _barcodeHistoryDao;
      }
    }
  }
}
