using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace Sccin.WebSafe
{
    /// <summary>
    /// 对所有输入，输出进行验证
    /// 1.在可信系统（比如：服务器）上执行所有的数据验证。
    /// 2.识别所有的数据源，并将其分为可信的和不可信的。验证所有来自不可信数据源（比如：数据库，文件流，等）的数据。
    /// 3.应当为应用程序应提供一个集中的输入验证规则。
    /// 4.为所有输入明确恰当的字符集，比如：UTF-8。
    /// 5.在输入验证前，将数据按照常用字符进行编码（规范化）。
    /// 6.丢弃任何没有通过输入验证的数据。
    /// 7.确定系统是否支持 UTF-8 扩展字符集，如果支持，在 UTF-8 解码完成以后进行输入验证。
    /// 8.在处理以前，验证所有来自客户端的数据，包括：所有参数、URL、HTTP 头信息（比如：cookie 名字和数据值）。确定包括了来自 JavaScript、Flash 或其他嵌入代码的 post back 信息。
    /// 9.验证在请求和响应的报头信息中只含有 ASCII 字符。
    /// 10.核实来自重定向输入的数据（一个攻击者可能向重定向的目标直接提交恶意代码，从而避开应用程序逻辑以及在重定向前执行的任何验证）。
    /// 12.验证正确的数据类型。
    /// 13.验证数据范围。
    /// 14.验证数据长度。
    /// 15.尽可能采用“白名单”形式，验证所有的输入。
    /// 16.如果任何潜在的危险字符必须被作为输入，请确保您执行了额外的控制，比如：输出编码、特定的安全 API、以及在应用程序中使用的原因。部分常见的危险字符包括：
    ///         < > " ' % ( ) & + \ \' \" 。
    /// 17.如果您使用的标准验证规则无法验证下面的输入，那么它们需要被单独验证：
    ///     验证空字节(%00)；
    ///     验证换行符(%0d, %0a, \r, \n)；
    ///     验证路径替代字符“点-点-斜杠”（../或..\）。如果支持 UTF-8 扩展字符集编码，验证替代字符： %c0%ae%c0%ae/ (使用规范化 验证双编码或其他类型的编码攻击)。
    /// </summary>
    public class Safe
    {
        //文本字符
        private const string TxtRegex = @"^\+/v(8|9)|\b(and|or)\b.{1,6}?(=|>|<|\bin\b|\blike\b)|<\s*script\b|<\s*img\b|\bexec\b|\bselect\b|\bdeclare\b|union.+?select|update.+?set|insert\s+into.+?values|(select|delete).+?from|(create|alter|drop|truncate)\s+(table|database)";

        //文件
        private const string FileRegex = @"";

        public  bool CheckData(string inputData)
        {
            var param = !string.IsNullOrEmpty(inputData) ? inputData.ToLower() : "";
            param = !string.IsNullOrEmpty(param) ? param.Replace(" ", "") : "";

            if (param.Contains("+++") || param.Contains("=="))
            {
                return true;
            }

            if (Regex.IsMatch(param, TxtRegex))
            {
                return true;
            }
            else
            {                
                if (param.Contains("+++") || param.Contains("=="))
                {
                    return true;
                }
                if (Regex.IsMatch(param, TxtRegex))
                {
                    return true;
                }
                return false;
            }
        }
    }
}
