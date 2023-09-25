import scrapy


# 民俗名称，地区，价格，房间类型及数量，床的数量，可住几人
class MeituanItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    title = scrapy.Field()
    place = scrapy.Field()
    price = scrapy.Field()

    room = scrapy.Field()
    bed_num = scrapy.Field()
    num = scrapy.Field()