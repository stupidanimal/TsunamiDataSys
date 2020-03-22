READ_FILE = 'all_source.txt'
from sqlalchemy import create_engine, func
from sqlalchemy.types import UserDefinedType
from sqlalchemy import Column, String, Integer
from sqlalchemy.orm import scoped_session, sessionmaker
from sqlalchemy.ext.declarative import declarative_base

from conf import setting

ModelBase = declarative_base()
db_url = f'mysql+mysqlconnector://{setting.DB_USER}:{setting.DB_PWD}@{setting.DB_URL}:{setting.DB_HOST}/{setting.DB_NAME}'

engine = create_engine(db_url, convert_unicode=True)
DBSession = sessionmaker(bind=engine)
session = DBSession()


class Point(UserDefinedType):
    def get_col_spec(self):
        return "POINT"

    def bind_expression(self, bindvalue):
        return func.ST_GeomFromText(bindvalue, type_=self)


class EasyGeometry(UserDefinedType):

    def get_col_spec(self):
        return "GEOMETRY"

    def bind_expression(self, bindvalue):
        return func.ST_GeomFromText(bindvalue, type_=self)

    def column_expression(self, col):
        return func.ST_AsText(col, type_=self)

    def bind_processor(self, dialect):
        def process(value):
            if value is None:
                return None
            assert isinstance(value, tuple)
            lat, lng = value
            return "POINT(%s %s)" % (lng, lat)

        return process

    def result_processor(self, dialect, coltype):
        def process(value):
            if value is None:
                return None
            # m = re.match(r'^POINT\((\S+) (\S+)\)$', value)
            # lng, lat = m.groups()
            lng, lat = value[6:-1].split()  # 'POINT(135.00 35.00)' => ('135.00', '35.00')
            return (float(lat), float(lng))

        return process


class BasePointModel(ModelBase):
    id = Column(Integer, autoincrement=True, primary_key=True, nullable=False)
    point = Column(EasyGeometry, nullable=False)
    __tablename__ = 'station_info'


class BasePoint:
    def __init__(self, id, point):
        self.id = id
        self.point = point


def read_file():
    with open(READ_FILE, 'r') as f:
        for line in f:
            # print(line)
            split_list = line.split()
            # 需要判断第一个是否为 >
            if len(split_list) > 0 and split_list[0] == '>':
                pass
            elif len(split_list) > 0:
                print(split_list)
                lat, lng = split_list[1], split_list[2]
                # temp_model = BasePointModel(point=(lat, lng))
                temp_model = BasePointModel()
                temp_model.id = split_list[0]
                temp_model.point = (lat, lng)
                session.add(temp_model)
                session.commit()
            pass


def main():
    read_file()
    print('写入完成')
    pass


if __name__ == '__main__':
    main()
