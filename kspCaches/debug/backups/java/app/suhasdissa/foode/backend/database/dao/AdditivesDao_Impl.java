package app.suhasdissa.foode.backend.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import app.suhasdissa.foode.backend.database.entities.AdditivesEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AdditivesDao_Impl implements AdditivesDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfSetFavourite;

  public AdditivesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfSetFavourite = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE additives SET favourite = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void setFavourite(final int id, final int favourite) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetFavourite.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, favourite);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetFavourite.release(_stmt);
    }
  }

  @Override
  public Flow<List<AdditivesEntity>> getAll() {
    final String _sql = "SELECT * FROM additives";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"additives"}, new Callable<List<AdditivesEntity>>() {
      @Override
      public List<AdditivesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfECode = CursorUtil.getColumnIndexOrThrow(_cursor, "e_code");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
          final int _cursorIndexOfEType = CursorUtil.getColumnIndexOrThrow(_cursor, "e_type");
          final int _cursorIndexOfHalalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "halal_status");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
          final int _cursorIndexOfHealthRating = CursorUtil.getColumnIndexOrThrow(_cursor, "health_rating");
          final List<AdditivesEntity> _result = new ArrayList<AdditivesEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AdditivesEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpECode;
            if (_cursor.isNull(_cursorIndexOfECode)) {
              _tmpECode = null;
            } else {
              _tmpECode = _cursor.getString(_cursorIndexOfECode);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpInfo;
            if (_cursor.isNull(_cursorIndexOfInfo)) {
              _tmpInfo = null;
            } else {
              _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
            }
            final String _tmpEType;
            if (_cursor.isNull(_cursorIndexOfEType)) {
              _tmpEType = null;
            } else {
              _tmpEType = _cursor.getString(_cursorIndexOfEType);
            }
            final int _tmpHalalStatus;
            _tmpHalalStatus = _cursor.getInt(_cursorIndexOfHalalStatus);
            final int _tmpIsFavourite;
            _tmpIsFavourite = _cursor.getInt(_cursorIndexOfIsFavourite);
            final int _tmpHealthRating;
            _tmpHealthRating = _cursor.getInt(_cursorIndexOfHealthRating);
            _item = new AdditivesEntity(_tmpId,_tmpECode,_tmpTitle,_tmpInfo,_tmpEType,_tmpHalalStatus,_tmpIsFavourite,_tmpHealthRating);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<AdditivesEntity> search(final String search) {
    final String _sql = "SELECT * FROM additives WHERE e_code LIKE ? OR title LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    _argIndex = 2;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfECode = CursorUtil.getColumnIndexOrThrow(_cursor, "e_code");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
      final int _cursorIndexOfEType = CursorUtil.getColumnIndexOrThrow(_cursor, "e_type");
      final int _cursorIndexOfHalalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "halal_status");
      final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
      final int _cursorIndexOfHealthRating = CursorUtil.getColumnIndexOrThrow(_cursor, "health_rating");
      final List<AdditivesEntity> _result = new ArrayList<AdditivesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AdditivesEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpECode;
        if (_cursor.isNull(_cursorIndexOfECode)) {
          _tmpECode = null;
        } else {
          _tmpECode = _cursor.getString(_cursorIndexOfECode);
        }
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpInfo;
        if (_cursor.isNull(_cursorIndexOfInfo)) {
          _tmpInfo = null;
        } else {
          _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
        }
        final String _tmpEType;
        if (_cursor.isNull(_cursorIndexOfEType)) {
          _tmpEType = null;
        } else {
          _tmpEType = _cursor.getString(_cursorIndexOfEType);
        }
        final int _tmpHalalStatus;
        _tmpHalalStatus = _cursor.getInt(_cursorIndexOfHalalStatus);
        final int _tmpIsFavourite;
        _tmpIsFavourite = _cursor.getInt(_cursorIndexOfIsFavourite);
        final int _tmpHealthRating;
        _tmpHealthRating = _cursor.getInt(_cursorIndexOfHealthRating);
        _item = new AdditivesEntity(_tmpId,_tmpECode,_tmpTitle,_tmpInfo,_tmpEType,_tmpHalalStatus,_tmpIsFavourite,_tmpHealthRating);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<AdditivesEntity>> getFavourites() {
    final String _sql = "SELECT * FROM additives WHERE favourite LIKE 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"additives"}, new Callable<List<AdditivesEntity>>() {
      @Override
      public List<AdditivesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfECode = CursorUtil.getColumnIndexOrThrow(_cursor, "e_code");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
          final int _cursorIndexOfEType = CursorUtil.getColumnIndexOrThrow(_cursor, "e_type");
          final int _cursorIndexOfHalalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "halal_status");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
          final int _cursorIndexOfHealthRating = CursorUtil.getColumnIndexOrThrow(_cursor, "health_rating");
          final List<AdditivesEntity> _result = new ArrayList<AdditivesEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AdditivesEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpECode;
            if (_cursor.isNull(_cursorIndexOfECode)) {
              _tmpECode = null;
            } else {
              _tmpECode = _cursor.getString(_cursorIndexOfECode);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpInfo;
            if (_cursor.isNull(_cursorIndexOfInfo)) {
              _tmpInfo = null;
            } else {
              _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
            }
            final String _tmpEType;
            if (_cursor.isNull(_cursorIndexOfEType)) {
              _tmpEType = null;
            } else {
              _tmpEType = _cursor.getString(_cursorIndexOfEType);
            }
            final int _tmpHalalStatus;
            _tmpHalalStatus = _cursor.getInt(_cursorIndexOfHalalStatus);
            final int _tmpIsFavourite;
            _tmpIsFavourite = _cursor.getInt(_cursorIndexOfIsFavourite);
            final int _tmpHealthRating;
            _tmpHealthRating = _cursor.getInt(_cursorIndexOfHealthRating);
            _item = new AdditivesEntity(_tmpId,_tmpECode,_tmpTitle,_tmpInfo,_tmpEType,_tmpHalalStatus,_tmpIsFavourite,_tmpHealthRating);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public AdditivesEntity getOne(final int id) {
    final String _sql = "SELECT * FROM additives WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfECode = CursorUtil.getColumnIndexOrThrow(_cursor, "e_code");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
      final int _cursorIndexOfEType = CursorUtil.getColumnIndexOrThrow(_cursor, "e_type");
      final int _cursorIndexOfHalalStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "halal_status");
      final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
      final int _cursorIndexOfHealthRating = CursorUtil.getColumnIndexOrThrow(_cursor, "health_rating");
      final AdditivesEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpECode;
        if (_cursor.isNull(_cursorIndexOfECode)) {
          _tmpECode = null;
        } else {
          _tmpECode = _cursor.getString(_cursorIndexOfECode);
        }
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpInfo;
        if (_cursor.isNull(_cursorIndexOfInfo)) {
          _tmpInfo = null;
        } else {
          _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
        }
        final String _tmpEType;
        if (_cursor.isNull(_cursorIndexOfEType)) {
          _tmpEType = null;
        } else {
          _tmpEType = _cursor.getString(_cursorIndexOfEType);
        }
        final int _tmpHalalStatus;
        _tmpHalalStatus = _cursor.getInt(_cursorIndexOfHalalStatus);
        final int _tmpIsFavourite;
        _tmpIsFavourite = _cursor.getInt(_cursorIndexOfIsFavourite);
        final int _tmpHealthRating;
        _tmpHealthRating = _cursor.getInt(_cursorIndexOfHealthRating);
        _result = new AdditivesEntity(_tmpId,_tmpECode,_tmpTitle,_tmpInfo,_tmpEType,_tmpHalalStatus,_tmpIsFavourite,_tmpHealthRating);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
