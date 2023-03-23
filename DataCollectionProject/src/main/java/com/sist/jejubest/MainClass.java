package com.sist.jejubest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// <div class="thumbnail">
// <a href="/product/3공-다이어리-팩-퍼플-핑크-로즈골드/3300/category/59/display/1/">
/*
 *   <div class="detailArea">
        <div class="xans-element- xans-product xans-product-image imgArea"><div class="RW ">
                <div class="prdImg">
                    <div class="thumbnail">
                        <a href="/product/image_zoom2.html?product_no=3300&cate_no=59&display_group=1" alt="P0000EWY" onclick="window.open(this.href, 'image_zoom2', 'toolbar=no,scrollbars=auto,resizable=yes,width=450,height=693,left=0,top=0', this);return false;">
                            <img src="//jejubest.com/web/product/big/202303/479500762fdb24e76025f54f3242ca76.jpg" alt="3공 다이어리 팩 (퍼플, 핑크, 로즈골드)" class="BigImage ">                        </a>
                        <div id="zoom_wrap"></div>
                    </div>
                </div>
                <div class="xans-element- xans-product xans-product-addimage listImg"><div class="inner">
                        <ul class="list">
<li class="xans-record-"><img src="//jejubest.com/web/product/small/202303/a9904b2593e51ad88c812250085a5d4c.jpg"  class="ThumbImage" alt="" /></li>
                                                    </ul>
</div>
<button type="button" class="prev"><i aria-hidden="true" class="icon icoArrowLeft"></i>이전</button>
<button type="button" class="next"><i aria-hidden="true" class="icon icoArrowRight"></i>다음</button>
</div>
            </div>
<div class="RTMB ">
                <p class="prdImg">
                    <a href="#none" id="prdDetailImg" data-param="?product_no=3300&cate_no=59&display_group=1" class="thumbnail">
                        <img src="//jejubest.com/web/product/big/202303/479500762fdb24e76025f54f3242ca76.jpg" class="bigImage" alt="3공 다이어리 팩 (퍼플, 핑크, 로즈골드)">                    </a>
                </p>
                            </div>
</div>

        <div class="infoArea">
            <div class="headingArea ">
                <h1>3공 다이어리 팩 (퍼플, 핑크, 로즈골드)</h1>
                <span class="delivery displaynone">(해외배송 가능상품)</span>
                <span class="icon">       </span>
            </div>
            <div class="xans-element- xans-product xans-product-detaildesign"><!--
                    출력 갯수 지정 변수, 없으면 설정된 전체가 나옵니다.
                    count = 10
                -->
<table border="1">
<caption> 기본 정보</caption>
                    <tbody>
<tr class=" xans-record-">
<th scope="row"><span style="font-size:16px;color:#555555;">상품명</span></th>
                            <td><span style="font-size:16px;color:#555555;">3공 다이어리 팩 (퍼플, 핑크, 로즈골드)</span></td>
                        </tr>
<tr class=" xans-record-">
<th scope="row"><span style="font-size:12px;color:#008BCC;font-weight:bold;">판매가</span></th>
                            <td><span style="font-size:12px;color:#008BCC;font-weight:bold;"><strong id="span_product_price_text">12,000원 </strong><input id="product_price" name="product_price" value="" type="hidden"  /></span></td>
                        </tr>
<tr class=" xans-record-">
<th scope="row"><span style="font-size:12px;color:#555555;">국내·해외배송</span></th>
                            <td><span style="font-size:12px;color:#555555;">국내배송</span></td>
                        </tr>
<tr class=" xans-record-">
<th scope="row"><span style="font-size:12px;color:#555555;">배송방법</span></th>
                            <td><span style="font-size:12px;color:#555555;">택배</span></td>
                        </tr>
<tr class=" xans-record-">
<th scope="row"><span style="font-size:12px;color:#555555;">배송비</span></th>
                            <td><span style="font-size:12px;color:#555555;"><span class="delv_price_B"><select name="delivery_cost_prepaid" id="delivery_cost_prepaid"  >
<option value="P" selected="selected">주문시 결제(선결제)</option>
<option value="C">수령시 결제(착불)</option>
</select><strong>4,000원</strong> (50,000원 이상 구매 시 무료)</span></span></td>
                        </tr>
</tbody>
 */
public class MainClass {

	public static void getJejuData()
	{
		try
		{
			GoodsVO vo=new GoodsVO();
			Document doc=Jsoup.connect("https://jejubest.com/category/%EC%A0%84%EC%B2%B4%EC%83%81%ED%92%88/59/").get();
			Elements link=doc.select("div.prdList__item div.thumbnail a");
			for(int i=0;i<link.size();i++)
			{
				Document doc2=Jsoup.connect("https://jejubest.com"+link.get(i).attr("href")).get();
				Element image=doc2.selectFirst("div.detailArea div.thumbnail img.bigImage");
				Elements etc=doc2.select("tr.xans-record- th span");
				System.out.println(image.attr("src"));
				vo.setPoster(image.attr("src"));
				for(int j=0;j<etc.size();j++)
				{
					String etc_msg=etc.get(j).text();
					if(etc_msg.equals("상품명"))
					{
						Element name=doc2.select("tr.xans-record- td span").get(j);
						System.out.println(name.text());
						vo.setName(name.text());
					}
					else if(etc_msg.equals("판매가"))
					{
						Element name=doc2.select("tr.xans-record- td span").get(j);
						System.out.println(name.text());
						vo.setPrice(name.text());
					}
					else if(etc_msg.equals("국내·해외배송"))
					{
						Element name=doc2.select("tr.xans-record- td span").get(j);
						System.out.println(name.text());
						vo.setSend1(name.text());
					}
					else if(etc_msg.equals("배송방법"))
					{
						Element name=doc2.select("tr.xans-record- td span").get(j);
						System.out.println(name.text());
						vo.setSend2(name.text());
					}
					else if(etc_msg.equals("배송비"))
					{
						Element name=doc2.select("tr.xans-record- td span").get(j);
						System.out.println(name.text());
						vo.setSendPrice(name.text());
					}
					
				}
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        getJejuData();
	}

}
