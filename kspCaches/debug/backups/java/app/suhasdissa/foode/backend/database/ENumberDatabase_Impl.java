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
import app.suhasdissa.foode.backend.database.dao.AdditivesDao;
import app.suhasdissa.foode.backend.database.dao.AdditivesDao_Impl;
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
public final class ENumberDatabase_Impl extends ENumberDatabase {
  private volatile AdditivesDao _additivesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `additives` (`id` INTEGER NOT NULL, `e_code` TEXT NOT NULL, `title` TEXT NOT NULL, `info` TEXT NOT NULL, `e_type` TEXT NOT NULL, `halal_status` INTEGER NOT NULL, `favourite` INTEGER NOT NULL, `health_rating` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1f39b629fce82d0f97d22939afb35d3f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `additives`");
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
        final HashMap<String, TableInfo.Column> _columnsAdditives = new HashMap<String, TableInfo.Column>(8);
        _columnsAdditives.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdditives.put("e_code", new TableInfo.Column("e_code", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdditives.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdditives.put("info", new TableInfo.Column("info", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdditives.put("e_type", new TableInfo.Column("e_type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdditives.put("halal_status", new TableInfo.Column("halal_status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdditives.put("favourite", new TableInfo.Column("favourite", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdditives.put("health_rating", new TableInfo.Column("health_rating", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAdditives = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAdditives = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAdditives = new TableInfo("additives", _columnsAdditives, _foreignKeysAdditives, _indicesAdditives);
        final TableInfo _existingAdditives = TableInfo.read(_db, "additives");
        if (! _infoAdditives.equals(_existingAdditives)) {
          return new RoomOpenHelper.ValidationResult(false, "additives(app.suhasdissa.foode.backend.database.entities.AdditivesEntity).\n"
                  + " Expected:\n" + _infoAdditives + "\n"
                  + " Found:\n" + _existingAdditives);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "1f39b629fce82d0f97d22939afb35d3f", "7a5040585aadb63ccc0aa06a773b2966");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "additives");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `additives`");
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
    _typeConvertersMap.put(AdditivesDao.class, AdditivesDao_Impl.getRequiredConverters());
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
    return Arrays.asList();
  }

  @Override
  public AdditivesDao additivesDao() {
    if (_additivesDao != null) {
      return _additivesDao;
    } else {
      synchronized(this) {
        if(_additivesDao == null) {
          _additivesDao = new AdditivesDao_Impl(this);
        }
        return _additivesDao;
      }
    }
  }
}
