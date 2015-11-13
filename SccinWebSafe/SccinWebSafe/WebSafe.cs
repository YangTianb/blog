using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;

namespace Sccin.WebSafe
{
    public class WebSafe : Safe
    {
        public  bool PostData()
        {
            bool result = false;
            if (HttpContext.Current.Request.Path == "/expert/w_exp_ElectronicSignature.aspx") 
            {
                return false;
            }
            if (HttpContext.Current.Request.Path.Contains("w_spv_CollectExpertMark.aspx"))
            {
                return false;
            }
            for (int i = 0; i < HttpContext.Current.Request.Form.Count; i++)
            {
                if (HttpContext.Current.Request.Form.AllKeys[i] == "__EVENTVALIDATION" || HttpContext.Current.Request.Form.AllKeys[i] == "__VIEWSTATE")
                    continue;
                result = base.CheckData(HttpContext.Current.Request.Form[i].ToString());
                if (result)
                {
                    break;
                }
            }
            return result;
        }


        public bool GetData()
        {
            bool result = false;
            if (HttpContext.Current.Request.Path == "/expert/w_exp_ElectronicSignature.aspx")
            {
                return false;
            }
            if (HttpContext.Current.Request.Path.Contains("w_spv_CollectExpertMark.aspx"))
            {
                return false;
            }
            for (int i = 0; i < HttpContext.Current.Request.QueryString.Count; i++)
            {
                result =base.CheckData(HttpContext.Current.Request.QueryString[i].ToString());
                if (result)
                {
                    break;
                }
            }
            return result;
        }


        public bool CookieData()
        {
            bool result = false;
            for (int i = 0; i < HttpContext.Current.Request.Cookies.Count; i++)
            {
                result = base.CheckData(HttpContext.Current.Request.Cookies[i].Value);
                if (result)
                {
                    break;
                }
            }
            return result;

        }

        public  bool referer()
        {
            bool result = false;
            return result = base.CheckData(HttpContext.Current.Request.UrlReferrer.ToString());
        }

     

        //进行url解码
        public static string MyUrlDeCode(string str, System.Text.Encoding encoding)
        {
            if (encoding == null)
            {
                System.Text.Encoding utf8 = System.Text.Encoding.UTF8;
                //首先用utf-8进行解码                    
                string code = HttpUtility.UrlDecode(str.ToUpper(), utf8);
                //将已经解码的字符再次进行编码.
                string encode = HttpUtility.UrlEncode(code, utf8).ToUpper();
                if (str == encode)
                    encoding = System.Text.Encoding.UTF8;
                else
                    encoding = System.Text.Encoding.GetEncoding("gb2312");
            }
            return HttpUtility.UrlDecode(str, encoding);
        }
    }
}