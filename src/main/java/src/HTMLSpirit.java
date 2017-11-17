package src;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLSpirit{
    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }


    public static  void main(String args[]){
        String test_str = "<?xml version='1.0' encoding='utf-8'?>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "  <head>\n" +
                "    <title>程序员的思维修炼:开发认知潜能的九堂课 (图灵程序设计丛书)</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                "  <link href=\"stylesheet.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"page_styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "</head>\n" +
                "  <body class=\"calibre\">\n" +
                "<p id=\"filepos340857\" class=\"calibre1\"><span class=\"calibre2\"><span class=\"bold\">第6章　主动学习</span></span></p><p class=\"calibre23\"><span class=\"calibre24\">大脑不是一个用于填充的容器，而是一束需要点燃的火焰。</span></p><p class=\"calibre25\"><span class=\"calibre24\">——普卢塔赫［Mestrius Plutarchos（Plutarch）,</span></p><p class=\"calibre25\"><span class=\"calibre24\">公元45—125］，希腊哲学家，阿波罗司祭</span></p><p class=\"calibre16\" style=\"margin:0pt; border:0pt; height:1em\"> </p><p class=\"calibre8\">在当今技术和文化环境下，学习能力可能是成功的最重要因素。它决定了你是“大获全胜”还是“勉强通过”。</p><p class=\"calibre8\">在本章中，我们将看一看学习的真正含义，了解为什么学习会突然变得如此重要，探索有助于主动学习的技术。首先，我们将研究一下如何随着时间的流逝来管理目标和制定学习计划，同时关注如何保持L型和R型平衡有效地协同工作。</p><p class=\"calibre8\">以上述这些想法为基础，我们将探讨一些独特的技巧来帮助大家提升学习的能力，例如阅读技巧和思维导图等，同时也帮助大家更好地利用手头上的学习工具。我们还将看一看哪些学习方式和个性也会对学习造成影响。</p><p class=\"calibre8\">我们可以提升你的学习能力，但首先要说一说学习是什么。</p><p id=\"filepos342289\" class=\"calibre13\"><span class=\"calibre17\"><span class=\"bold\">6.1　学习是什么……不是什么</span></span></p><p class=\"calibre29\">虽然很多人力资源部门至今还没有意识到，但实际上，了解Java、Ruby、.NET或iPhone SDK并不是特别重要。总会有新技术或者现存技术的新版本需要学习。技术本身并不重要，持续学习才是最重要的。</p><p class=\"calibre8\">历史上，曾经不是这样。中世纪的农民耕种土地的方式，几乎和自己的父辈一样，也和父辈的父辈一样。信息以口头的形式传播，并且一直延续到不久以前，一个人仍旧无需太多正规教育和培训也可以养活家庭。</p><p class=\"calibre8\">但是随着信息时代的来临，一切开始改变。人们感觉变化的速度比以往任何时候都快，新技术、新文化规范、新法律挑战、新社会问题，都快速袭来。各种科学信息的主要内容都产生于最近十五年。在某些科学领域，可用信息的数量三年翻一番。最后一位无所不知的圣人很可能是英国哲学家约翰·斯图亚特·穆勒（John Stuart Mills）——他于1873年去世<sup class=\"calibre26\"><small id=\"filepos343481\" class=\"calibre27\"><a href=\"#filepos414507\"><span class=\"calibre28\">〔1〕</span></a></small></sup>。</p><p class=\"calibre9\"><img src=\"images/00037.jpg\" class=\"calibre74\"/></p><p class=\"calibre35\">我们有许多东西需要学习，我们必须持续学习。别无他法。但是“学习”这个词可能给人一些不舒服的感觉，总是让人想起年轻时埋头于黑板粉尘中的岁月，或参加公司组织的单调枯燥的“复印机”似的培训之类的低质量教育活动。</p><p class=\"calibre8\">这不是它的全部意义所在。事实上，我们似乎往往误解了教育的真正含义。</p><p class=\"calibre8\">教育（Education）来自于拉丁文educare，字面意思是“被引出”，即引导出某样东西。我发现一件非常有趣的事情，当我们想到教育时，通常并不考虑它这个词源的含义——从学习者那里引导出一些东西。</p><p class=\"calibre8\">相反，更常见的看法是把教育当作学习者被动接受的事情——灌输，而不是引导。这种模型在公司培训中尤其流行，称之为羊浸式培训。</p><p class=\"calibre8\">羊浸（现实中）是指把毫无防备的羊浸到一个大水箱里面做清洗，去除它们身上的寄生虫（见图6-1）。羊排成一队，你抓起一只浸到水箱里，让它感受一次强烈的、陌生的、中毒性的清洗经历。当然，药性会逐渐失效，所以过段时间你不得不对它们再次做清洗。</p><p class=\"calibre9\"><img src=\"images/00038.jpg\" class=\"calibre75\"/></p><p class=\"calibre9\"><span class=\"calibre24\"><span class=\"bold\">图6-1　羊浸：陌生的、中毒性的、暂时性的清洗</span></span></p><p class=\"calibre35\">羊浸式培训遵循同样的模式。你召集起不知情的员工，在一个陌生的环境中通过密集的方式、三到五天的时间培训他们，和日常世界没有任何联系，然后宣布他们已经成为Java开发人员、.NET开发人员或者你所设想的任何头衔。当然，培训的效果会逐渐减弱，于是第二年你必需再来一次“进修”课程——另一次羊浸式培训。</p><p class=\"calibre15\"><span class=\"calibre7\"><span class=\"bold\">“羊浸式”培训不起作用。</span></span></p><p class=\"calibre18\"><span class=\"calibre7\"><span class=\"bold\">Sheep dip training doesn't work.</span></span></p><p class=\"calibre29\">公司喜欢这种标准化的“羊浸式”培训。容易购买，便于安排时间，每个人随后被放进一个可爱的小盒子里：现在你拥有了一盒九片装的.NET开发人员。这就像是快餐鸡块。只有一个缺点：这种天真的办法不起作用。原因如下。</p><p class=\"calibre8\">□　学习不是强加于你的，而是需要你主动做的事情。</p><p class=\"calibre8\">□　仅仅掌握知识，而不去实践，没有用。</p><p class=\"calibre8\">□　随机的方法，没有目标和反馈，往往会导致随机的结果。</p><p class=\"calibre13\"><span class=\"calibre7\"><span class=\"bold\">点燃你的火焰</span></span></p><p class=\"calibre30\"><span class=\"calibre24\">一旦我们抓住要点，我们必须互相鼓励，彼此主动交流，利用记忆指导我们最初的想法，接受别人的说法，并将其作为一个起点，一个需要孕育和成长的种子。大脑不是一个需要灌输的容器，它应该被比作需要点燃的火焰——只需点燃——然后它便激发出人们的创造力，并逐渐使其产生对真理的渴望。</span></p><p class=\"calibre8\"><span class=\"calibre24\">“假设有人原本去找他邻居要火，结果发现邻居那儿很暖和，于是他就继续呆在那边取暖。这就好比是，某人去向别人学习知识，却没有意识到他应该点燃自己的火焰、他自己的智慧，而只是很高兴地着迷于他人的演讲，老师的话只是触发了联想思维，就好比只是让他的两颊泛起红晕，只是让他四肢感到温暖，但是，虽然笼罩在智慧的温暖光茫下，他内心的阴冷昏暗却没有被驱散。”</span></p><p class=\"calibre25\"><span class=\"calibre24\">——普卢塔赫，希腊历史学家、传记作家和评论家</span></p><p class=\"calibre16\" style=\"margin:0pt; border:0pt; height:1em\"> </p><p class=\"calibre8\">正如普卢塔赫在本章开头文字中所说的，大脑不是一个用于灌输的容器而是一束需要点燃的火焰——你自己的火焰。这不是别人可以帮你做的（参见上述完整引文），而是一件你必须自己做的事情。</p><p class=\"calibre8\">此外，令人惊讶的是，只是掌握知识的提纲并不会提高专业水平<sup class=\"calibre26\"><small id=\"filepos348250\" class=\"calibre27\"><a href=\"#filepos414670\"><span class=\"calibre28\">〔2〕</span></a></small></sup>。当然，掌握它非常有用，但是它对你的现实日常工作没有贡献很多。</p><p class=\"calibre8\">这引起了一些有趣的问题。除了不停控诉羊浸式培训外，人们还严重怀疑大多数（甚至全部）技术认证项目。“知识体”显然并不重要。大脑构建的模型、为构建模型所提出的问题和你的日常经验和实践对你的业绩更加重要，它们才能提高你的竞争力和专长。仅仅掌握知识是不够的。</p><p class=\"calibre8\">单纯密集、脱离情境的课堂教育最多只能给你正确的方向。你需要持续的目标，需要反馈以了解你的进展，需要更加主动全面的学习，而不是在令人窒息的教室里一年上一次课。</p><p class=\"calibre8\">在本章剩余部分，我们将研究如何在现实中使学习更有效率。我们将看看如何利用手头上的最佳工具来更系统地着手学习，以提高学习能力。</p<<a href=\"#filepos394607\"><span class=\"calibre24\">〔13〕</span></a><span class=\"calibre24\">　感谢Bert Bates提供的信息。</span></p><p id=\"filepos417249\" class=\"calibre8\"><a href=\"#filepos397965\"><span class=\"calibre24\">〔14〕</span></a><span class=\"calibre24\">　我使用能同时在Mac和Windows上运行的NovaMind，见http://www.novamind.com。</span></p><p id=\"filepos417448\" class=\"calibre8\"><a href=\"#filepos403633\"><span class=\"calibre24\">〔15〕</span></a><span class=\"calibre24\">　参见Behind Closed Doors:Secrets of Great Management［RD05］一书中的Affinity Grouping。</span></p><p id=\"filepos417656\" class=\"calibre8\"><a href=\"#filepos404569\"><span class=\"calibre24\">〔16〕</span></a><span class=\"calibre24\">　很多手机和笔记本电脑现在都内置摄像头，因此这件事变得很容易。</span></p><p id=\"filepos417859\" class=\"calibre8\"><a href=\"#filepos406821\"><span class=\"calibre24\">〔17〕</span></a><span class=\"calibre24\">　参见The Prepared Mind: Neural Activity Prior to Problem Presentation Predicts Subsequent Solution by Sudden Insight［Kou06］。</span></p><p id=\"filepos418103\" class=\"calibre8\"><a href=\"#filepos389079\"><span class=\"calibre24\">*</span></a><span class=\"calibre24\">　参见The Critical Importance of Retrieval for Learning（KR08）。感谢琼·金姆（June Kim）提供的信息。</span></p><div class=\"mbppagebreak\" id=\"calibre_pb_14\"></div></body></html>\n" ;
        String res = HTMLSpirit.delHTMLTag(test_str);
        System.out.println(res);
    }


}