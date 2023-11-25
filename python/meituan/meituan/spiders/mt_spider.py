import scrapy
from ..items import MeituanItem


class MtSpiderSpider(scrapy.Spider):
    name = 'mt_spider'
    allowed_domains = ['minsu.dianping.com']
    max_page = 17
    city = input("请输入您要入住的酒店城市：")
    # start_urls = [f'https://minsu.dianping.com/zhenjiang/pn{page}/'for page in range(1, max_page+1)]
    start_urls = [f'https://minsu.dianping.com/{city}']
    cookie = {
        'uuid': 'DEDA9E3B9445E0456AC4E184611C03856CD06D8EB119B96FB4E5C7E9A10C0894',
        'iuuid': 'DEDA9E3B9445E0456AC4E184611C03856CD06D8EB119B96FB4E5C7E9A10C0894',
        'zgwww': 'd8c66050-6df4-11ec-b97e-5b303ab7854f',
        'phx_wake_up_type': 'mtpc_category',
        'phx_wake_up_source': 'nav',
        '_lxsdk_cuid': '17e2907f435c8-0d137c1f0260d8-57b1a33-1fa400-17e2907f436c8',
        '_lxsdk': 'DEDA9E3B9445E0456AC4E184611C03856CD06D8EB119B96FB4E5C7E9A10C0894',
        '_hc.v': '8048cc0f-4a2b-74fa-a6e5-8e66be935872.1641365894',
        '_ga': 'GA1.2.1807144298.1641365895',
        '_gid': 'GA1.2.353209009.1641365895',
        'XSRF-TOKEN': 'RHjkGP8U-WxvBm7zU25nkqltB-5gPhVflhcs,',
        '_lxsdk_s': '17e2907f436-872-2d7-13c%7C%7C630',
    }

    def start_requests(self):
        for page in range(1, self.max_page + 1):
            base_url = 'https://minsu.dianping.com/{}/pn{}'.format(self.city, page)
            yield scrapy.Request(base_url, callback=self.parse)

    def parse(self, response):
        all = response.xpath('.//div[@class="r-card-list v-stretch h-stretch"]').xpath(
            './/div[@class="r-card-list__item shrink-in-sm"]')
        for i in all:
            hrefs = i.xpath('.//a[@class="product-card-container"]/@href').extract_first()
            item = MeituanItem()
            item['title'] = i.xpath('./div/a/figure/figcaption/div/text()').extract_first('')
            item['place'] = i.xpath('./div/a/figure/figcaption/div/div[@class="mt-2"]/text()').extract_first('')
            item['price'] = i.xpath('.//span[@class="product-card__price__latest"]/text()').extract_first('')
            item['room'] = i.xpath('./div/a/figure/figcaption/div/div[1]/text()').extract_first('').split(' · ')[0]
            item['bed_num'] = i.xpath('./div/a/figure/figcaption/div/div[1]/text()').extract_first('').split(' · ')[1]
            item['num'] = i.xpath('./div/a/figure/figcaption/div/div[1]/text()').extract_first('').split(' · ')[2]
            href = response.urljoin(hrefs)
            yield scrapy.Request(url=href, callback=self.new_parse, meta={'item': item})

        # # 翻页操作
        # next_page = response.xpath('.//ul[@class="phx-paginator-wrapper"]/li[10]/a/@href').extract_first()
        # print(response.urljoin(next_page))
        # yield scrapy.Request(response.urljoin(next_page), callback=self.parse)

    def new_parse(self, response):
        item = response.meta['item']
        ul = response.xpath('.//div').extract_first()
        # print(ul)
        yield item