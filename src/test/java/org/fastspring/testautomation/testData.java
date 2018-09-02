package org.fastspring.testautomation;

public class testData {
	
	public static String payload="{\n" + 
			"  \"products\": [\n" + 
			"    {\n" + 
			"      \"product\": \"PhotoCollage\",                                                 \n" + 
			"      \"display\": {                                                              \n" + 
			"        \"en\": \"Photo Collage & Photo Editor\"                                                          \n" + 
			"      },\n" + 
			"      \"description\": {\n" + 
			"        \"summary\": {\n" + 
			"          \"en\": \"Create fun, amazing layout & collage by remixing your own photos with text,sticker, motion and sharing them with your friends\"                                                        \n" + 
			"        },\n" + 
			"        \"action\": {\n" + 
			"          \"en\": \"Customize Layout with sticker background text frame\"                                                        \n" + 
			"        },\n" + 
			"        \"full\": {\n" + 
			"          \"en\": \"Layouts\"                                                        \n" + 
			"        }\n" + 
			"      },\n" + 
			"      \"fulfillment\": {\n" + 
			"        \"instructions\":{                                                        \n" + 
			"          \"en\":\"Deliver a seamless order and return process.\",                                                        \n" + 
			"          \"es\":\"Allows customers to order from any device and return to the store or fulfillment center\"                                                         \n" + 
			"        } \n" + 
			"      },\n" + 
			"      \"fulfillments\": [ \n" + 
			"            { \n" + 
			"               \"type\":\"file\",                                                                                     \n" + 
			"               \"url\":\"http://developer.ebay.com/devzone/merchant-products/mip-samples/ebay-feed-xml/product-search.xml\",\n" + 
			"               \"display\":\"product-search.xml\",\n" + 
			"               \"applicability\":\"ALWAYS\",                                       \n" + 
			"               \"behavior\":\"CURRENT\"                                              \n" + 
			"            } \n" + 
			"         ] ,\n" + 
			"      \"image\": \"http://www.herbalclinic-swansea.co.uk/wp-content/uploads/2018/05/individual-mosaic.jpg\",             \n" + 
			"      \"format\": \"digital\",                                                      \n" + 
			"      \"sku\": \"7865765656\",                                                          \n" + 
			"      \"attributes\": {                                                           \n" + 
			"        \"OrderManagement\": \"Latest and most innovative technology and multi-channel interfaces to provide a complete view of orders placed and product demand.\",\n" + 
			"        \"Fulfillment Completion\": \"The consistently flawless fulfillment of orders need to quickly scale to accommodate seasonal demand, sales and promotions\"\n" + 
			"      }, \n" + 
			"      \"pricing\": {\n" + 
			"        \"trial\": 2,                                                             \n" + 
			"        \"interval\": \"month\",                                                    \n" + 
			"        \"intervalLength\": 1,                                                    \n" + 
			"        \"quantityBehavior\": \"allow\",                                            \n" + 
			"        \"quantityDefault\": 1,\n" + 
			"        \"price\": {\n" + 
			"          \"USD\": 50.99,                                                        \n" + 
			"          \"EUR\": 43.88\n" + 
			"        },\n" + 
			"        \"quantityDiscounts\": {                                                   \n" + 
			"          30: {\"USD\": 25, \"EUR\": 15},\n" + 
			"          10: {\"USD\": 15.00, \"EUR\": 10.00}\n" + 
			"        },\n" + 
			"        \"discountReason\": {\n" + 
			"          \"en\": \"Labor Day\"\n" + 
			"        },\n" + 
			"        \"discountDuration\": 3\n" + 
			"      }\n" + 
			"    }\n" + 
			"  ]\n" + 
			"}";
}