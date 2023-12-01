package com.example.ss10_list_customer.controller;

import com.example.ss10_list_customer.model.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerServlet" , value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
  private static  List<Customer> customerList;
  static {
    customerList = new ArrayList<>();
    customerList.add(new Customer("Thành Văn","01/01/2001","Đà nẵng","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoGCBUVExcTExUXGBcYGhkcGRgaGhoZGhsfGx0ZGRwaIBwcHysjHSApHxkaJDUkKCwuMjIyGiE3PDcxOysxMy4BCwsLDw4PHRERHTEoIygxMTExMTMzMTE0MTEzMTExMTExMTExMTExMTExMTExMTExMTExMTExMTExMTExMTExMf/AABEIAPsAyQMBIgACEQEDEQH/xAAbAAACAwEBAQAAAAAAAAAAAAAEBQADBgECB//EAEQQAAIBAgQEAwQIAwYEBwEAAAECEQADBBIhMQUiQVEGE2EycYGRI0JSobHB0fAUFeEHM1NicpKCorLxF0Nzo8LT4hb/xAAZAQADAQEBAAAAAAAAAAAAAAAAAgMBBAX/xAAkEQACAgICAgMBAAMAAAAAAAAAAQIRAyESMUFRBBMiYTJxgf/aAAwDAQACEQMRAD8A+zVKlSgCVyu1KAJUqVKAJXK7XKAJXalSgDldqVygDtSpUoAlcrtSgCVypUoAlSpUoAldqVygCV2pXKAJXK7UoA7UqVKAJUqVKAJUqVKAJUqVKAJUqVKAJUqVKAJUqVKAOVKlSgCVK7UoA5UqVKAJUqVKAJUqVKAJUrtSgCVK5XaAJUqVKAOV2uV2gCVKlSgDlSoTVDYlRpIrHJLs1JvovqUA/EkHXTvRGHxKvsaRZIt0ma4SStoIqVypVBSVK7XKAJUqV2gDlcrtUX8Sq7nXtSykoq2ak3pF9SlV7HnoIFQ446AfOueXy4Ir9ExnNRGB2oE4iYivdq5rSL5cXKl0L9bSDalVo017rrjJSVoShFjeMjQ22kdRQ+E40wbm1FZ43jETpUW53rz3lk3dncscUqo3nD8XnExFF1leBcSVYBOlG8U4woHI2s11QzLhcns55YnypDk3QDBOtcN9ftCshiOIOWDZpqk4ok5iam/kP0Ovjr2bkGuO4Ak1nOGcShlzNKmqvEXFpORDoN4qn3rjYn0vlQRxnHyYVoFKnxMCJmgFxAnmrxcvgkkaelcknyds64pRVINGIJ0plwsMv0jHKOk6T61RgcKEQXLgBYjlU7Cdie/u/WvOIumZJk+utPHH5YrlejRWuKJGra+40TZxSNs35fjWONw7fd3/AFr1axhtkGZHcbj9RV1ka7IvAn0bVXB2INdrOM8r5tswdzG3voqxxxNA+mmtMs6upaJvDKrjsdVKGw2JDgkHSuXscinKTrVecauyfCV1RVxLFZQQDrSVrjMcxNe+K44FuWPfQIvV5efI5Se9Hp/HxVHrYapkAmmFq0GHQDvSRblXpcNc3NLtWPkwt9Me27aquh1qwAb0ms3iKNtXZoh8qN040cc8Ml5GiAV6oK3dNXebXq4/kwaOZwdnzIvOor0s0FZldTXvzImK4jusOttrVtx6U4fGZp6UQLpG4oQWGI/rVd2/Q64mN6Hv4mTptWgmF/xVVvi9aWu5JMVbh0J3FbRoU1+j+AWxcvIp1GpPuXX+nxpacK0xFPfCmFKG47b5Qo/4iP0poK2ZLocY25Lemv7/AH2pZffmjsJ/ED86Ja5qf3vr+dDMJuR3b7gB+YaulsmjlwHRepEk9h/WiFsACKC/i7YusWbWYAGp091Hi8IkVPsqtFnBLuRzbPstJH5j8/hQnFMKUeB7J1U+nb99xQxx2VwzMqhSDl3MbanoOlPseouWZ6rrP4/AzPypHVB/jJP2KcNiXX2SYqXLpJk1y3FWyIqN2WRTmr0K9KoqaVJorGR6Fe0mq89dS5UminYUpq61digTcr0t0VGcExJY7Q4s4mat84d6TrcqzzKnc46RzywKzEYLmX31VxA5CBm3E14w93SVYLM8ppbxBbqvDqQTr769dROeyxLkEx3ozD4sk6mlGDLkkBdTpT3C4AW2UXTMiY7GhoEMcJgluCS0Vfe4WkaNFKQ2VjBOWdx09K92sRzBQ5MnrQkaF28IFYazTO3glWqsOEVSzsNNqr/mCsNDOtK3Q4dABnSjMCwKsB3T8SKz1zEmTrpTTw9iMwuDsk/IimxybkZLo8278u3aSfgJ/Kqbd7VmPQH5sT/+qpvHIHPcwPgAfvJA+BpXexcBR9o/Ppp6Adas2YkF2Lt03DkRVQtq0AsfUCnmCtnLz7n9zFThLqEFe7+IMkhSQOgiZ+JoSVDNu6KU4WoYtGp39dv0HyFMcHcE+UfrqR8h/WgbmKJWWyoRtJAJ9N4r3bJL22/zfiKyVGq2tinzCDvtXs4oihOJNkuuo6M34mg7lzSuaiqY3GJJr35lKsPeplhLGYZiwidup91K4tlE0e1uzVqMDsanE/L08sEQOal4vRUpqnRSDtWMs1egaW270mib0rHUGouLLqmH2nojI3agMDdBIHrTePWrY8XJWQyumIVexaQm8FLn2tNj0ANRThsRDmVcCAftCst4xR8+j8pMx6jrRvhu7FuWMmZmvRk/ymeXWxzZ4ZnCcuTK56akf1ovi1u3BRhDRp3rlnGK4IBnTpvQapdu3MuUl40zaaUsv4MnXZVhMIFUqx5Se2tDXMBbLKCYg7+lHcRtXbKzdUgdI1rzwMWmBu3yYmAOlSqV0byVCrxfYUIuRuXaKXeHLgKuk6jUfnWy43wW3fAW1KIIJPf3TXeA+FbFq55oJIAIg6j310LE3GmJ9kUzG38Vv91P/BF2Xf8A9N5+4/lSnFcIuG9cVbbhczZCFJG+mtNfBGGe3dK3FKtkYEH1K1KMakPdo74oU5co0k5Z9/8A3pfxPCzDDpGUeg2Hypr4gSVHowHyMT+dAed5iabjQj3bj4fgQaskbYz4RfV7YZT6EdQe1esSLqyVOa32Tlf5kGfhBrL3luW28y0SJ9odPeR9xpxw3jbxzpPuP5GlaodMJwai44QWoUkF2aWYgQYzNqBImBTq24N/INkKn4nNP3R99JMX4gCCUQ5jtO3xonwyx9tjJJGY9y2aT82++sGexd4gDNfuZQTrrSrDhnaACa3V3gSG4buYyZnXvXLnCwhB5SRt0NTcGYpozf8ALWygH2m1Ea0z4dZhAHHXf0pjdsNIYCHj4VV5NxlIca707jFoI5GD8Uw8IzWpIG9LsPw9mQvMaTBG9aLCXVtkIw6daORUcgqdulTeKMtjLK4md4HhDnOdNxpI2ps+DzKVMD0o5rZBJDadoqoINyZ9axQUVRv2NuwJMAAQdABuKL/h17/fRBsSsgzXn+HFMoV4MeVvyCvwfD3AGZZB7ir24PYCyQNKuFsbJcyqNx+VccEIchkzsat4o4rZbh+G2hqq1L9ob9dtdDQ9i5cALMNNuXcfCKIDl1nK2+kjeh9GbKxgUEeYc3vMxXWw9orlyrlJ2I616e9kQkgHKNdJ99UQLkMo5tYB0+Imj/RoDfdnuNbAKpbjmGx9KJs28qaSZojCYeGPmSNonY1VftuFOUgc+gH4+lU5uticVei+3cMiEG1IODHzMRevmRmYqoPRUEfeSD8u1MMbde2GeNlMAST/AEpdwNMmHNwzLkgd4GrH4kH7qmnbLRQJxVxluE/aA++BWbxitbbOPZb2tNB2MduhrQ4LDNfhfq+ZLeseyPi2vuVqY8V4ZbCx7Pv/AK7/ANaahr8GZwbhzDe4/H16+n7m98KFUsNqEu2PLJEjoFPxBA116Ufwd8wNtuo6+mk/vsO1K1ZROhXdtSST20+YrR8DXlIHU6e9Tp88oHxpVxK0UEdiAfdIkfgfhTHw+/ISN1ZT8hJ/6o+NZVDXaNZilkSGAG8n17VzBuvUiehNdvOCvTaYOxB3E/vpQLYK2RIdhrIAYQPnQ9OyHgYyhknU9a5dCRqCSe3pSviAe2Vg5gBqTA/CiMJfa6swAR1FJz3RvHVnm9at+YCRr2P3VficM2XkADGphrJzhi4MnUEb0ez5QSRtrP8ASnUbWzHKnoTtZu5coOo6n8KrVXyQ4EyZpupDc6dRv0+VA3cQM5BA+Gs+lJKEUUjNii3iLimBOvSvf8e/rVnFlCJ5pTLrpB1M/lS/+dr/AIY+dQk6dWVTs0rOtwggSpOh2191H2XUHKI21NIn8zVltjywZE6ET6jpQ1geWznz0L75Z0g9J6muhZK8HG4jfH4vyw0liNlAgGa8cPxxOjtlI+0CJ93eg+Hu4bzLhkRIkSY71auNLuggak5cwggAfvSjluwoY3riZRnYrO4HWhnvW8qjM0MxAYj2R768+Qz3Bq2m8AbdpND4699KttSihVJjf5/KncnXRlDLHklQslgYG3NHcUrxtxFbylVg0CTJjTuOlE4niPssiMZEBoOU+npWXxeNZrpzAI0e1JIOv70pJy9GxRpb3l3ENtLhLnLpJ19B1iheNQqi2NkWPQbE/lSrhN4eYIDETqYga9dek96Y8VfMrHuPzg/ga2ErKRQR4aQARHsKCf8AU8k/ELA/4zTa8inekvhh/ombvcb7gq/iDTC7eqykLJbB8Zw+04KuikH0j4gjUH1pLi+Gi0y6ypPK53B+y3eR16+hinFy/QvEPpEKHr+waJVQQtMFxuE8y2WAlhAYdwOnvjr39DQPhhij5CfaAHxG0/Om/Ar+ca6OvK46MOhH79KDxmH8vEZe/Mp/T99Km+rKrujQ+SHtiZGUzAnpuIG+nT0pNxTHEBgzwB/dhV3EdD+VPbBZkBX2t99Cex9DrSXj9oujXFjlJ5I2bqJ2InqKTInWhF2XI8qtzNmOUggnqdRoa8o72oDGFcAhp0BpLgMddcgLbJYbwpJE6VZxG5cRZugQrRBOo+HSo7qxrGy8T5hnYwNZHWo+PuXTlRgN5Hp76zFnFS+kBO29XLet/anX9xS830PxRobeObMAOaYAEwKYX76DSBm6wNB7zQL4S01oMGyHoRpHwpbbv2FlVxJKsCGUQXHxqtNIW0xk2OtMCrZjHfX5UJ5tn7C0lxd1EueWHZkiQ0d6HzetRbY6Rqmw72g03ORTsTrljT360NaKOrAc5BzOQuYAHaD39Kx+M47duBLzdGyqxMjTpl/On/AsYzwcyyWjLIRZGu+5mndN6OezR2HzyxW4dIQLPNG5ynYChOI4MkXA5e3Ch1bSVJkDUdNNqtxHEPItBrVsl2ZQc55V9ppAkwOUgRvSPjniEsZuJK5QApaAHYnURuIC77a1aXFL+iKxr/HG1bF1DcdnAAjVP+LsdNqrNlGU3rinPmMsokGdY+/rWf4dx76PyWZPLGgQiOYkEAEDf1o7DcYxLC+LFljkMZDlIBiTPQ6a79RWLejegi3xi4ocEE2xoIPNrpSk4pV0YjXaTrrua8WuF32tpyrlujMr25aDuQwX2T91DWuEvdZz5lsi37bMSg2BABI36UlXoax3wjEzfJtlgpADMSQpB0UHsD3pmVdbLZwZAJze0pEyCGiDNZiw7NZyLdkW3HZZP1QCOo31prwjigxCXPTQxImQ24mCdAJ/OSXhoaLGXhq5GHH+q5Pxdj+dMXNI+BPFu6h+rcPyZV/MN8q0vCMCSqtcGkaKdz6n09P2bwi5PQuSSirZRheGtc1Jyr07n3D86MGDs20zPt1JM/cKYXrgUSdAKRcWxPmIhXQZzoeh9a6eCijk+yUmEYrDWltNesougzEroYXmYf7Z+dDXsIcQFCEB7bDmO2Xr8xt8tKLwrLZDqxBlZy9+n3zQHg++Rda226qAfXTepziuSLQm+L/gwsqUOXXQ6j8/mPvpBxDErcuhsO7MG9pVmQ20xsJ9exrWcStahx7j+RrK3Xt2X+jU5876jKikj0nXc6nf5VDJCtFFO0pB11WtWzetuVLMMysV7xlmN9Kz/iMriZuSFEAEEQ2YbZT+daLC4RPKF67muZ8rC2SCNdoHXfauC1YtmfLLuW5cxiJPrsBtSON+dApUZrgnCXtwz2yyx7IGuncdzV3EQUuC5athVKREaAk9uhrTJxC4CTdyLbkQ6gnKfsnuI6+tV37WcubRXI2puFgVnbRR179KV41x0xlN3szPEMPcP95cgEA5SdG9wHWhuDcJW+Xi7kiQigDXTX4URxzhV8sFYl1+2oBC+8CnGG4DZRVuWncNlhWkgZu8b1KEW5XQ7loWeGbKWb2Rwt1mT6Nui5Tqpn4fKtVp/hp8qD8P8GFsZrgDsCYiTlG5IJ9aZ/xg/wA3yrojHWyUpbMDxPw+r2gbVsXbrPL3LRJVcx6AcpjWvGC4DaOHF43grJny24B1GxI3DdfjTHDeIbiOFypbtsxLEHRCx30GsEmRFMreBwTBw4MMpdmYwzSTLD62vYRGkVNcfACDB4AFBibty69xrbjKACq5NpI9J+Z71jvEF8jKvMCObmAiSSSQd/fX0XyyqeRhUy23QhEY8+ViWLGdVHbMZNK+E8Jw5tpcCWrWIt3PpDdus7IUMXMyNoQy5jA05gR0NCirswR8G4Vea0X8lyLhD6QHyZdWUPoROulPsHw4ulqzh8QVtvmzIG52YjMWAA06yCY9KYcZwvnn6Bhbt2lZVAaLdzMA30ZXpGkdDRHBuFquHtsMMi3UABHMGYjYhus7zT8GmLaoxPFbjYTFWrFi9fLARdthWRssyWBBhiRmPwrzcdQmIFm4xBaQzHoDEN679KJ8RW2v3g7G1aa2z3CWP0hVCENvMCW1Mwp03ou74jtoUsC1at85dco0LAzJEbnU61umtG9GPxTLbvXbclghADKCA3WddQda1H9nt5c5WDLTvvouunb19aJxHh8YjDnEXC9suT5KW+dnZmk5lC7fHQdRQ3CkTAXALzMbhVQxPKql5zLvrGmta0EXs1vhfh+fE3WP92AmYfaIJKj/AKp/rWsu462sy+28An4aCs3wLjFpbboCCzNoQZDFgqgSNjtp66UUJvA21hQI9kR866sf+OiOXctnviOP8zlA5R39o/CaEtYNmkGckz7+x9+4/wC1NLfDlBQQCZM9u/z2Hzrt26UUhIlG1O41nT4aVWiN+gW3gm5Wnfc65vd8ulEYDALbdrpMFgBFHW1FwDcayR69v60NxTEpAVCCVPMP6/Cjir2bzdaGFq5mMdO3f30o4jwOx5wvFOd5Hdc0TmynTYHX8zXrC4uNaD8S49SAhJhjsoktGpAHyHxpcsEosbHJtnMPw9bOQWmdystzsWQaEAADrqYFdw2Nt3bbO7MIaCSoyztlg7696U3sCb11XRHW0CVYZwhIMAkQAQcykHU79Kr47wi4itdt8ltINu2rZkZhsWza6zv6V5710jqW/I5wLoFATO4zNmMZV01CqDAEnSrbFy27QwKOBGT2VM6ie5rD2eJ31IDHy2bV9Q3tRBABMHr3oxrlxbtu/dLXAp7HNpoQNNN+tLytDJGq4OGV2S4wALMeUCIJ9kk6z+lML7kkeUF0PUnXXtSfhvEWuKHuWwEZiLY2YD/NJ7+nWq+J4y5lzsACCfLIbbXLtOvv2p1JJUjGrYfe4xk8w5wxBghVML0I/wBXxpT/ADFvt3v9opW2IuD22BDMMwEQT1O9X/xyfa/5R+tTeR+zVFIq4vwpVUi85EGAROhGUhgToNDm32U1MRh2D3FsubltMuZgVLNlXmJUb7iCNJI1FOL91bttrdtHkkZzoQwzLGXMQ0yyrMDt00BwD3Df/h7LPbgOzggqEZtl3OypoOuYnpoNL/gqZV4S43cUtacny1OY3LgLMokfR8ukx1kxFU+LsE1+4b1pWe1yMTbUjORyET7tJ9KZfykW0W2zJbLOeVAmSSphiDqNBl9T2FUYXGNbS1ZF3yUKuR5mW4CJHKFUyN5EnrtTW6pmasF4PxjEgeUltC9owLR0YiTCxtmHU+la3CvfuWCLqItwiIzR8su0e+shY8OvfvLdS64SR9IEKi4Ob1BE5CM3qPSmmBwt21i3t27v0bWmbIpFx0bTlXP12MtpzAdaZSl0zGl4Lm4FhXuuj5g4VFMSS8y06dwDp6GsLxjCYdXe/bt3H+kItFlYKQoKltdSQwgADrrvX0s4Q2sOtpLhXM+r6CcxP+YN2HKSdgIGwXEUCpaXy/MfTJcSYD6BmaTmy5tJk6laZ6Rl2EeHHdcMhyBWZcwlSQkj2WE5p3001kV58TYV7tvybWVPOAVnNtiwzRzE/dlmddwBVN3iD27RvPmbPCs1oBnJXTOuaJSQ+UZfxq6xxEwHeDcDBFthgoMww0ZozGR7oNMpWqZleRTf4Dlv4TEWcxt2SEuZhlZgXdQSgUey8kyPrTpBrU8PsMtxmVgbZGkQdZ0HcQJoC7fRHl3LNeBJQHOFheYkZjKCFACfWbrm0LfidlHKNCF/bO0NED4R19ffXTjaqiM0+y6+xMqm+xI6dxPfualrC5RGkdTXrzrSr7aBfRgZpRjsQ92cpHlzovf1PUmqtk1sL4nj/wDy7TR3I/Ckro0BuxgnqSdatwNgkmQAO40+41fjsNcU+xKD2Y1HqW7Vi2x1oDbEEURiLNpFF++x0y5YIG+ZcpkwQZXtQ2Gt5n70l4hwK9cxBKc1t380ea0JCxyvlnuRp0jQVP5EvyPjjvQL4k4qz3XCYjOuhRc8jbbSATTHBYu7iFzNcDFNFsrmDsAQCwGzb/dQuK8N4Y23xdy4bQ/yrktj3TqQTsw6EGl3E8NewzhrTPat3JyFCQDsSNSW1311MV58lKrOhNDrir2bTDEXVuXlUIEmLbasZU7G6Rp7qs8S8YtsnlFYZs2XLcYKvv01Jnf8KrXC3hYFy9lyHqxLsqH6wSQdztvSfFIl9VKTbuBSCxJfMQJLBQOWTHoKxs0fXLlx1zWiS4tsS5gKqkgFQz6k6QNKS2MZbNt1NosyiFJflA2JjqesUJjeK3HtkNCvCrIaIP1ncCc3XSANKAwfEkt3RnE2wRmMQTlkdDtP3UrRthr4vKirkAYhupMwQASsQARtE0vzH7f3ijsenn3gv0aZ9EaciDKJG/SPvNAfwS/4g/3LSUbZtG4g9wvae1ce2WkXRKtbJzqxkkjKDrKkBSRudSXh7AS2623F0q6qyqDaKv5YHKFMgiAAF1ltehI+Dt3LnLcIKpagSFQEZjLvJKuRlbUdW1EGQVZ8vzVuMiwoDhSgDcoLqVU3JaOUyZEtvIqyaat9EvOhXhfD+IvhLhtszl9HdgBbggSSzM7kFCIKDQ9dac4bgmGt28vtYplzOLZXMXU8zIrkBeYExI0HpTDFcVuMl2ArKFEqGIc5pLIVZCqMFnTWZG1V8JvMzBbeVl1Z3aFOQxlAKqObeewY821UjxS0Zt9hhFws6rca4FyoyvbC2zLDNBWGLAbnUDsTNSzwgi1kUm0WIzlJ+r9XNIMH7Qg/krvY9XS5aUGLRZkIW4EBVWgZwSrGTmkkTSngXEbt22bjXHyq5W4yO5AKkEnKrCFI10MnWCJoclfQJM0PGLd1IdIZswaXViLYGltVA0XWSznoD3EU4HG5r1wqWc/WLKyoA0sVgmAAIkqeY+mgz/FeK3DcIK2hcYjIXiGVdDs/J7QbK2YAiNZFW2caBnV4NoiHhG1X2xlU9RrKwR8N1509GpX2aqxjM8r5ZKkqi5FaQIJzMx+rsRt166DPccxVpXa0ltbYXRnQHONYMQdUHJKqfrDaSQLiuKXFsuwkIzZShbQ7+0VJjaGOaNp0NK7GJzXmAhXGaJ0YnMZAuxn5j0YRRPJaSYKNMZJxRoFt7Vo4eFSGIGiiHIWAxJbSADttvLPg5t4i5ctlocGZaWdukFjuRy/MetCcMvXba3D5QOgcMzByIyyWzEaSDrHrpTfCG215c0m8bZ9grAQGCwWdNTlLdPZ7VXC/0hMi/JT/AClA9zMQwAUCB1MSN/QffUucFFu5bCqCGyzInrr8IpxZtotzKFIEDQ9+/wB1c8RX3AC2zlPcb+6a7aRzWzlrDgJlWPaO5AIIZtp33+UU0TQDUe79KSYi6lzDm4SOmb0bYj0NK2v+XoXJ25QZbXUT0X46+hobo2KbNDjcCizcSFO5XYH1HY+nX8c9w255thrDkqHWDIgqSN4O36V6t4p2IJMAaqo2HrPU+vyijVu22bMyDMd2GhMaa9/j2qGSXI6scHFbM/wXA5rxW/ckq2uFyZ1QLCgy8iCNo7il/inidu7eQrbuuliRc+ooMxAHTbf1rYYzCo6s9llW8UyBnkBgJKqxE7EnWKwuIwGOs2rtrynbPOa7bi4WBEEHLJ291Qa4xo2t2V8S8QIbtq9bt8qEznC5pkaBhMCJA95rwvFbYutintgq5YeXmICkkAEgLBIGs9etZiyyo2S4pBkyGkanuD00FesSj2zoQoJEzqPn099SktmpmrvXbRuPfe2mVxkXmYtKqDIggjNoMxEClPEeK2msm1h7AtFiM5MMza6jN1FKb2Kkw89gwYmI9P0r1c9nnie4iGH5GlVo2y6/ifMteVKq9pjAExGx1Pr1rnl3u4+dD4VD5guKRlVtiJnvI6ij/wCdDvb/ANlbSMs2tzguJdkdrT5kM2xnIGRmCErBgnaQY0djMGm17gYtWbb5T/EEAnmgqAzvOeIULmWWMDkHU6qeIeNnt2ltWFK5eRS7eYxgAACAsmSo5pPU0Pxjit+4Xs3Ga4hby2uKrIouEfRjeAJMmObsTAFP+I9Wxf0w57l8Wv4m4RysFby2a0GBMBo1zNPLJEzJjsHfu3lVC92Ld1QyqHb2SNVMcxIGm0EEbwYRXsSDcbTM5JVQwAJgxo24YxOuskGYNeQWCwxunM1sc49j2oBJEQSWJGwPbUCfgYP/AI82rUPcuMMo+jQqqSEtrlgEwM0GVy6GB9Wa7PFvMVXZlGmQDKQpKSMrQSdVfSDyzGsGa7823t3MSjpbJXOhDKQABKgKytARkMTqXB9DtOIcQ4aHRnUP5dvJlUFkgQ4nLykjUwdpNOo+3Rjfozf8G1wqFNvMSPLtPHmNIEnUBQIcyZ1DA8jTmIxBt2yn0/mPGZsmT6Jhk5WGzW1bNoN8wnuaPHfECuLcmEhbRmSDzNmUt2YZTy9FAgkTOfuYoqi5lN1izqs8pXrlkk88uAC0zmMyRNNx7QWPv5nfuXwLoGVlVkzIq9nVl2VwTlEqe5WDqe38PL5kYEsAMpIYqV1VBB1CkKNNdNtjWex9wmblvywRoIVQTAbMrACSGB13iddAMrDhWMN6JueWwQOpdmUnIhKnPJMkdYJ5CRScPIWaThap5rNefy3GQqhQWVkwC5gGPaUgEKQV1GoNaDwrwsWle5El20MKCVGg0XTU5m/49da+f4bibvb8pk81rrhbZYsbgc6aE9yRvoCOs6/VsPZCW1tgmFULOstAiddda6/jQ3ZDNLVFWIbUMIJX9kUm4ziroMgJqZ1DH/5U9uJ6QO1A8SsSR++1dkonPGRj8Xh7twlhc8snqqJ850YH1DUGcHiLQkAXF35fa16kbk+6a1d62qgsxAAjcgb6CO+vQelVY5AFInXlmDBgsBpGvyqUoxfZeE2ujP4bjABysCrDcHQj3g7U1w3EkNAcUw4uIpnLatyWgLEe8g5QN/WRWQxuJa3cut5gVFfKoC511KQQwPs83UzvvGvNODi6TOmGRNbR9Ls4pT1oq2/rXzC1xt7YlzB+sNAV1I5paJkEb9CN9K1OFx9wW1ugoyNlgzHtRB21GvSk5PyiiSfRp8Th0uCL1tLo7XFV/wDqBikfEvB2GuaKHtEiCEOZY/0tO3oRVWK8SrZcJdIQkTJMrGupbYbdac4TFo4BDgz19/at0zGjI4n+zdzraxaE9ntlPvVm/CvFrwzxCxZe1aSy8zqLizrv/eZelbok96j4orvDD1g0cELRgPD/AIOxFwv5ts2CigqTDI5J9nlYjbqNtK0//h7h/wDGf/alW4t0c+TckLdBywSpkb5W6MAfiDrIkUr/AP5Gx3/9u3U3A2jN49RbIDi4q/SSYi5zZVBUsJAMZdcs6SRIDX4s3LmLtqHA8rIUAzjNCIxVQTEs2bfXWCSaZ8b4bZxFwDDXgtsrlS6r5g+QHzFaeVtHbVREACYUCkPiDFC1cuFdbtpEtllAOrgKNBv9GbjCRsBWOO6Ql+Qvw7ibF7EvbxLhLLgrLZUE/VBZ4IaQCoytm22BjbYjiWFwtm3ZdDd5hoqRciywIZx1K/aGhA7Gvm4dHW3fw1x/4lee8RKKhILFhpMZgSWkxK6Azl0WCRLqHES+ZlKp5jEtF1becyVE8hDCZ1G/bZzUI60Yo2y/x74ksXka5btMXsubZe5GVCWhnUKTPMMofoVgdSEXD8IzNZwdjIl0lWcsRAcFrgt8xOY2w1yV1nMV+rTTinF/KR1ZF5WBtA6FiVQNcciOU3OUDQNDdBpmPDvh3GP5d62hdblxjmDpnYpmIPtZoLqZb9JrVJzjbCuJqPGnhw2kW9ib2d7rlOXMcpKl8xJPP7BEEaBjFZtrYCS7yUKNnUTn5WIIOnNCwZOmXrIlvicU2e2MTcLtmuZw6BkU27htZwCeWBM7mC22kPfFuDtYlDbwhW4wtlwts5CxQLCCEIkhphjMx30RSa0+zWkYgYh7Vq2ECDzVBXmW4+QMnt+pWOVhBDajQxZiruTLcXNbLhkbMWGQhzk3Oo1DEHUZ9zNVjhF7DBRfXyxN9gbkKNUti2G10l1YZQZJMiQCRdwTDW8TiEw65bdo80uCQ5bMwWMytDRG4MJ0IFWqtimm/swwfm3jdaclnUCIGdhlAid1Ck6dQtfR2eknhawbVtrfl20UEQ1piwutlAZ4MwICgCTse0liz/v9++u7Ckoo48rfIJzTVGPqyYWqeJGqMkhQ19bhuW2Rx5cczLAJIkFD1jTmGx9QaD46iXAG5STENAMRzGPQx8QYqnEY1VdgVufSN5aONVzMBywDtmJ1M65tgBVnGbwiSQADPuEEfnUyy7E3FMatu3kAl7sL5ag83MJUwI2J3iZpLxAXFu5RbK3GQOSDmcCDIVl9ocx5Sdm3E06wzfTh2LRyZFZScuchC0xyyF9mZgkmPZpZ4ibLiBmY5BJyICp1ZX5jJBhidYGhA1Fc2WlbOiHoR4bGLg7qubQc2g9oW2+jbOJe4XyqQ2XMVC7HOYkLmLfgfFziwq5FU2iNFJHeIUcoUAREEgtMgb5nFYsPdyKhuMGCDRgq5ZgALlIiGjfY7ma1nC+EPbw74l7lmwgAbKgm5nVucMdTmCFoBJksuw3SddspCVMSeIrrX8Xmt27lxUZVOVGfkiWmBp7bU1/s/wCD4lGYXMTbsJb1KXMrZl3ZlTOGSIOugk9dYXY3ENfQl3uA25VkW4XDKFzq6roCSJ00lRMdKH8O2L7XgcBlN0K2VlIWQqnuSo7HN2g71l1Ggt8rPp1jidsMALiujew4DANrlG4jVpUQTJGnSrsXdVIJg22gE9i2gn0O094HUVnsPw/E2rv8QwRbuRABcfMGMITlykkPGZCIjTNImaN8P27ttRh7+Hbyspti5PmK/KxaQs5FygjXYiNKnGfhlLL8WAeRoZdDbJ3VunvIGYDuD3FAfS/4jfIfrVt1PKc2WYkZQ1tmjUHYmOoIg+6YE1V/MX/wz8/601jKN7MP4Kw1xXN63ca2FVwSSJbkYkKCCDAEnTbT61av+0Lw3dt2VuG4Ia7DZSIAIAHtkKAQHMEgAltefTDYTFP5mI19kKiiBCqb1tSoGwESNO57mtbdx1y+xtXnZ0YpKk6GWtdqXI3GS/pGKtHrhvDVsa2bj3ELMud9VDqCpZTt5bZss/aBU66CziWJt2CAATqVt25ykhATJciFDAFh1gjaZrUYfB20lERVVSsKBAEZyNNtwD7xXzbxJcPnLrte09Ie4v4AD4VDgsuRJjXxWhZxK3fzKt1TnuHMzaiCxKIrHoqrrDagOe1ajwHeb6e3adg1sFlYHMzpbJN1U0GUHPbbTeDuaD/tQ4batW8I1tMpZDmIJ10Q9/WjP7N1hrT/AFsj6yZ/vbX6V05WuF0Ti3yD8Vg3bE2mm4XQGHyNnLvda5cYFdAFFx1zNABMicpNTiqpcdw9yEa4qs6wXVA1s8hYe2fLBnXWd4Mn4nEOqtcViHCnmG+rL1+FaDi3A8OyrcNsZoJmWGosFwYBj2lB+fczx4p/Yk1qir0ZviWNsjEWvJwzXbaLdy2bqmA5lGaXkAfaLzE/VgEc8Q4m0cqeRDXWQgm2FVsxAzSyBlg6F51CyB2XeJrpRrjqYYvdPccpbLodNPyFaDw9wizdspiLiZri3BDZmA1Wy2qg5TqSdR1roxO2rJz0tDmw9i/aChAEU8ykRlKyNx0mdQYIMa5q9qi5zeyw7KBJ3yjUT2J376KDtSPwbZUh2IBK3nUE6kCWUjXuAAe8CdhWhu716kNpM4MmnRfhW5QP836Ut8SM4JuLcYZR/d8pRhuQdJBO0g6ab6g1eIcS9vBXbltirqCQw3BBGtL3xL3MLZdzLMtssdNSSJNNJ7oyK1YUijIoOpzKfiGDz/yz76W4215zM0ErazEdQxX22P8AlWI/1A9hLnhSBrkMJARjH+39KI8OYK2EQhdkddydBlEansY+XYUje6KRXkzVzD3bylLMBspIBGrQOgJ0HrB7kAa0p8T8IxWdcQ9sm3bt87qV0jLmzDpqrPtrI9YfHEMmIv5IGW3eA5VMBSoA1HZR741p3ZUXGvpcVXUswysqkRLCIIjpXFnl+mvR041o+b+IPDlzJd4hhmW3ZGQ+W7gusKJYBRHKCpAbm1btql4feR8VZDs1y1eW2txGhcx1tEe3CEsgObNpvsIr6twzhdm7wix5ltWlbRJO5+lVdTuRGkbRVvF+A4VMbhCmHtLzAQEUDQXW9mImdZiaWE70xmZ+xwZMC5vvauxcXKquLV0LlDdmGZlQsokryrPNrFnA/Clo+ZeW2+S5cBtW0ZUKKAELi4wDLz5zA0KmddYa+Pr7JZFtDCAwFgEAK8Aa9gIq3weoTCJfUAXLovG48AlijALM9AOm1Ef03Zr0ii/4cyIM1y3btBjcYvo6yAAzOX1eIUHKBp3gFdxLHiwz28PcJtAhlub5M5U3FUsZcN5nmS2moAMGalnFvdxmIW42YWrihAYhQV1H39aL8VWVW1auKBnz2ubc+wB16RbX4idyanJJI1XYkxOMDGxbKP5gtctx7uUEPkYk2lDNtr6AMNYNEyv+X/be/wDpo/whhkvIfNRHnFFJZVJygGBMT133rcfybDf4Fr/Yv6UJ2NzaP//Z"));
    customerList.add(new Customer("Bảo lê","02/11/2001","Huế","data:image/jpeg;base64,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"));
    customerList.add(new Customer("Lê văn độ","10/11/2002","Quảng Nam","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBUWFRgVEhUZGBgZHBkaGBoYGBgaGBgYGBgZGRgaGhkcIS4lHB4rIRgYJjgmKy8xNTU1GiQ7QDszPy40NTEBDAwMEA8QHhISHzQrJSsxMTQ0NDE0NDQ0NDQ0NDQ0NDQxNDQ0NDQxNDQ0NDU0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NP/AABEIALcBEwMBIgACEQEDEQH/xAAcAAACAwEBAQEAAAAAAAAAAAAABQIEBgMBBwj/xABGEAACAQIDAgkGDgEDAwUAAAABAgADEQQSIQUxBiIyQVFhcXKxE4GRobLBBxQjJDNCUmJzgsLR4fA0ktLxFUNjFlOTorP/xAAYAQADAQEAAAAAAAAAAAAAAAAAAQIDBP/EACURAQEAAgICAgICAwEAAAAAAAABAhEhMQMSMlFBQiJhBBOxgf/aAAwDAQACEQMRAD8A+iLJiREmIEwXDw8d/wAP/dGnAlfm57y+wsVcO+W/4Y8GjfgT/jnvD2Fm8+LnvyphS3CTkae4dknM1nGxScj5RrcWv2Rod9wRYXzRXsV7Ix38YesD94zy2NgNDcmTe2k6VsewCM175gAPPEDb0/N4TQY/kNe1rDL2xA29fzeAhiWRfjIgxfLPYPfH2LiHF8s9glFDTC/QP+EPFZu9k/QUu4nsiYTDj5B/wx4rN3sr6Gl3E9kRXo8e1uEISViEIQAhCEAT8JeQnf8A0tM5THK7fcJo+EvITv8A6WmdpDldp8BKib292bvTs/TGfAD/ABfzt4LFuz96dn6Yx+D7/E/O3gsL0U7aeEISViEIQAhCEAIQhACZvhD9Mncb1H+ZpJnOEP0qdx/ERwqWwnsIwbCTEiJISQwPDrlv+GPAxxwJHzY94ewsT8OuXU/D9xjrgT/jHvD2Fm36uf8AartPcOydLSCbh2CTkLOdiEBGJ04w8BGBG9SdWzW6h/EX7EQFGvrxh6gIx1sdwOuX3e6Te2k6VdoAFGXXi5TEbb17G/THu0rmmRfUWvETHVexv0xwsi3FxDi+WewRntTadGm2SpUUOfq3u1ukgbh1mZ5trUXZij6brkEDQb79EZRo6A+QfuL4rN3sz6Gn3E9kTCUCPIPYg8RNxB+svRN3s0/JU+4vsiK9DH5f+LUIQktBCEIAQhCAKOEfITv/AKWmepjldvuE0PCPkJ3/ANLTP0xyu0+AlRN7e4D/ALfYPZl/4P8A/EHeb2VlHAfU7v6Zd+D3/EHfbwWF6KdtRCeEz0SViEIQAhCEAIQhACZzhD9Mncb2hNHM5wg+mTuN7QjhUutCShGDYSQkRJCIMBw65dT8P3GOuBP+Me8PYWJOHPLqdweBjvgT/jHvD2Fmv6uf9quUzoOweE63nJNw7B4ToJCzrYyXRhf6w9QUxgWBu1jxcw7bb/CL9j3yNl35x6LLf1XjBjre+gzX/vVrJvbTHpW2lpTYgatlv1f3dPnPDnhGcMipSZfLOD15ENuOR06EC/QTzWn0XaJsjEm+YrYdG79p+bOFdZ3xuILMb+VcdgViijzBQI4LN1yqFiS75nJN2uxLecnf4yCOCRdQAN5Jtb+9U54ak5dVAux0H9M12G4FVWAJYC+tjrFlnjj20x8eWXRBgse1M3psy6Hc1jY7wSOq/vn1j4PuET1XWlUqZmAJ4xsWUgAAg8plKAA77Nr1Y5uADm2Vxc799hO2B4J16OJoITcOwyst/qFc4PQQDeKZ45dDLC49vuUJ4osAJ7BIhCEAIQhAFHCLkJ3v0tENL63afAR9wi5Cd/8ASYgpHldp8BKnSb29wP1O7+mW/g8PzMd9vZWU8GdE7v6Zc+Du3xQH7zeCwvRT5NSBzn/iewhJWIQhACEIQAhCEAJmtvH5wv4Z9pv2mlmb28PnCfhn2j+8cKqVoQhGDUSQkRJCIPn/AA75dT8MeBjngR/jHvD2FiXh5y6n4Y8DHPAg/Nj3h7CzX9XP+1X0Og7B4SUiu4dg8JKQs72K1kawvxgPSFHvjEjXLbQ5ifP+9zF2xGARift29IUe+MCu9STdsxv0D+mRe2mPSvtHkNcaArb0i8/PG29m1FxNZ6iMoatUysykK/Hc3U7jpP0LtGxQjXilfPf/AJmD2ls9aoem6rlcPckcbPoQ4O7MCdOcW5pGefrr+2/i8fvb/TLcG9hZylU6Abukm/qm/oiLNjYI06aJmzFQAWta7c5tzayntVVBLVUrG25qbXO8DRQ3X0Tmt3ly65jrHhqKcY4CmHZCRyCWHnRlPteqZPZz1URmLu6WuvlBZxfmNhHHBHEtUqOxqlgoZcgplUuCAbMRxyOkdM18d5Y+WfxbCEITdyiEIQAhCEAT8I+Sne/SZn6Z5XafATQcJOSnf/SZnUPK7T4CVOk3tPB/U7v6Zc+Dj/DHfbwWUMG2id39Ev8AwbH5kvebwWF6KdtXCEJKxCEIAQhCAEIQgBM7t4fLp3D7U0Uzu3vpk7je1HCpfCEIwbCSEiJIRJfPuHnLf8P/AHRxwG/xj3h7CxXw/PGb8M++M+A/+Me8P/zWbfqxvypgu4dg8JKQTcOweAkjM1HewmGRgftX17Ft4RnxrHQZuNl7L6e6Z/ZbaN3gfUI2+M8YNbcCPTIt5a49DahOTS29c399EyG2apVlUDRwST0FT67gzQ7VrKqM7NYDjMTuAUEknqAEyOMxfl0R0UhSiul95D8YHq0FiOYgjrmfl167rXw79+HfB1LRk1iLtr5pncLiwe0b+oxxTxXFuAWPQLe+csrvsWMNXRiRdTxb2uCd1xcc0YYFAgVwLBairpzipxCOoXdG/LM9hcUc9zQUfeDoSoOt2HNqObpM0ruvkUC65ygXpOd1JPmW7dimbeOc7c3nuuD5WkgZQWqRODVGuTc3nRHJctG154zAb4ops2bNredKtYtC8XQmXBoDPCYpSs9iJ1qYhjY7rSZdntU4SNxUHPmPmFv5iCmeV2nwEY7bJ4hPOW90UoTxrdJ901x6TasU0ysFG4LpffySPdJfBzibYMD77eCyqlZ8+UprlPGzaWs3V1H0ztwLxSHDXw6ZUzaK+rXyrfW+6F6Tvlszil01g2MUEC+/n5oqfEdKrr0Frj1z1VB1mW1+xq2KUAm+6cMPjwxAtaLqyk7pBKbA3GlpXGi3dn6PckdEnE612zZgf5nZsYwsTYiK5aVsyvIeUErfGRbMDv5pBsTxQ0cspWrRqTP7ba9Ze43t290a08QGibbDXrrb/wBs+2ZRS7VoTyEFG4khIiexJYHh8eO34Z/VGnAc/Nm7R7CxXw/5bfhnxaMuAx+bN2j2Fm0+LG/KmSbh2DwkpFNw7B4T2pUVFLOwVVF2ZiAoA5yToBM1LmzW5faPCXatRUUs7BVAuWYgKB0knQCYmrw4w6K4oDyr3Fm3UxYW11BPZpfpmL21tyriR8u5Ycyg5UXsUaeff1xzxXLmql0ccPeGa1l+LYYnJf5R7Wz23KvPkvqSQL2HNvo8CeEaoRhcS1qTMfJOf+y7HVW/8bH0E33EkZHErOMu+PG4+t6XjlcbuPsG2NlMjZgMjczDkv1f3WVqO0cil6wyqu83Fuicfg34UCoowOLIY2tRZtc6gfRtf6ygcU84Ft4F+nDDZGGZmp/GHULlNRETyrIra3NmBUZdbsDvG/dOLL/Gsy1jy7Mf8jG4/wAuHvCLb1OlQZijKWZEXLa7ZgHI1OgyX1+8PNpdkYw1aCYgCyBVFEEgkg5Ud2toGN3UAHQX141hkOFFGi2K+L8V6dTD0KlInUBkNRFIP3lFiee4EpbM4UVcP83qXamAAivqFVSMoRhxgotaxvbdzTpx8FmPDj8nk9stvrD1bansFtSSdwA6ZzbFqL3DAgXII1t0jXWKMDwjw+IClRkcENlZ1s28EBgdN+82jlArMGZSAAQBmBJzbzcG1tJFxyx4qZp5XxABUX33PVYC5J6t0pjHi4NmAJspIsCeqWaeFUhg4PJ8mpv9XXXf1j0SFPDLpxSDcXfMG0HMoO68mQrKqtinZ2yWFjbUHUjfrfQTvTxV1vY8gv1ac1+mdUwaHPmzi7MbBgAQbb7Sb4dLtlU28mVG7ffQQ19HJSzbbg5OnU2vrY5Yronf3jGO2KQQIMtt+t+VoN4339UV0ntmPWZePR12pHjX15L7wB9volLgIfmi2+03gsuJUBYkA2yNY2tfisdB551+DlKfxJCxIOZr6dS9XRaVvUZ2bul8IzNrpbfLNMgcVTrL5o0T9ZvX+0iuFoA3DN/fNM7yqY6V0NhrDNeWfi1K987ej+J75CnzOfR/Ei41XKiKuslUq6Sz8Up35Z9H8TxsJTP1z6JPrRyqF+aGckZZbbBIfrn0T1MGg+v6pcxsFjjhxa56orxjXrD8L9cfJRQaZ/VEWPQLXADZvkr9nHMubvYk0hCEJSjcSUiJIRJYDh83HcdFPX/7RhwFPzZu0ewIs4dfSP8Ahj9UYcBD82bzexNv1Y35VKrwhw6cUOajLoQil7EaEZuQD1XmE4c8IjiClJFdES7OrFLs55F8rMLAX5/rdQlbAH5JNF1H2STvPREu0h8q97c24EDkrzc0WM5a604IxBuNOvnllK38/wDEqZeuSQkb902JccAyuyEbp1Q5l61gCGFjvj1skdVIZSQykMrA2IINwQeYggGaZcN8ZT45SqFMSXC1AWbWqwJDK29A4ViDfILFTltc5saaNu5j7jBHKZhoQystjqOMjJmt9oB2sea8XMu4P6rX7Uu9DB4k6E+Uw7WAAuCzLa2guVdrDTjm0VNiPKKUqWLK11NuMdBz9PjaNnxSfFKmEXjvQ8niA4IKlxVVcQFPQq1bDpyuZnawy1LjpvL6tn9/9L8R1oVTTcG9h0j+75veBu2icT8XLcWqpdOp0vnt2plPavXPnobMcp88YbJxppVaNZd9N3A6w67vH0yc8fbGwPtD5txI39W7T+ZFWI3m+702F/f/AEzrRZaiLUp3dHAZSAbEEXEPIEakHTqM4TriQ9hr2/20gmYbzf8Ap6uyV22tS3ZvUZE7VpdLf6f5ikFlR22DxCfve6KFPFbtaXcdi0e3GcWv9UHfb70qDJYjO2t/qDn/ADzSXSpK6Yc6fkb2DOPAFvmS95vBZ2R0H1mPFK8kDepF+V1yGwymGoCiuZwCTmNl325hfohuaK40+WqCN50lepjQTYEiUnx62sFP+of7ZyRw50Ug9JII8BFJNpymWjfDOTexOnWZH4yQDcmWqasE0AuZRxGFYbze8xmW8l5Y6xeHFNbeb9skmKcC5JldU5ybSbEkaTW9speHZ8UbXBMMPiHI4xIPNIpSyrrvnmYsd24SbtUM6dQ2N+iJqr3r3/8AH+uNKBurdn7xMv0zdz9YjxnDTfKxCEJajgSUgDJXgl8+4cH5R/wx4NGPADXDN+X2Is4cn5V/wx4NO/AXF5UWluLgMG6Mo1Fum00uUmM2wvyrB7Kb5NDoPykk8bqPjFm1XvVe2uo6tQoB8IzwdPKoXQZWK7iToer3xNjQRUe5+ux9Jv748e29c733eue8cfVBHOJ4AJZo7rei/heaxKthsQA9xu6OrcRLFZbG43SnikytmA0Oh7esS3RfMLGE+hU6dQHQwv8AVb8p6ertldtDOjcZSOfeIyWquPKUDTQEO7jOwO+mqkBAOss5bqC9ct4kXAcfZ184A98SjEMVO4MAQSRzEFSR0GxMZPVvSUDqHoub+oQl2LAj33SL1rU73txxr+Vv2nNNeaeYkgKubdnB9Ct+8CfbPg720pwSU8pzUuKwuL2Yl0PZY27VMfbX2oBQeykFhlG762l/Rc+afHuAmJdKyMlTKjE51tcumvosSGHPYHsP0XhDXGREB33Y9BA0U+szn8uOuftWOV3ogLT0NCAE52qV56DPAJICAE9noE9tAI2mo4ObPRqbM+8tYa20UfuT6JmZo8NQCooI1tr2nU+MrGJtmmgXApawJ9MG2eh5z6YiKTwKeYn0mV6wvbfZw2x0POfVPF2Mg3MfVF6s32m9JkfLP9tv9RhpP8foyfZIP1vVIHY+tw3q/mUlxFT7bSQxlX7Z9A/aHqf8V7/ppANiNdN0z2PwxSuQSDemp063b/bGq4+r9r1CKcbXZq7FjqEQDszOffCTR7iN4Ty8JQOLyUgJ6Yg+fcOR8q/4Q/XDgPRLCmw3IrE/6bDxkuG6/LHrpjxaZ7ZW0XosDTcqAACvMRa1iIeTKSTbLW8qW1TZ6o0GWrUXkkniuRzRVtilaoW+0L+caH3emOse6nEVshIVnzjRr8cZ+bdv55R2zTzIGG9fTY6HX0S8by1/BQFnWkpGo3emcVkxUtu3/wB3zaEs11DIRl41tOnq817RbSqWjJa5G+3n/t5Ctg0ZcyOFck3U3sb63HOD6fNHeeiciwYdfjPKR18ZotjcBsViKflaRS2YKFLENbnbdpboizH7Kq06jUaihXQ2YX9DXA1BGoil3dFYU4kjUDd4y4rnKgN7DqPOLadO6Sr7GrHkqG7rp4Fr+qN//TWOcK3xasVAFi6MoVRuAL2010Ah12OyrPKeNxBJUWvv05uqWMUjIzJUUoymzKwIZT0EHURc9S7dkMrwJOTPB40owYCxFiCCwII6wRPpOycW9WhTeobkqbd3MxHbvv558iUliFXUkgKOsmw7TefY8NRCIiDciqo/KAPdMPNnfWRpjjzt1Anonl56DMFpASQkQZMGAeiE9E9ECdMLSzOo6SL9m8+qaQmKNlJxi3QPWf4vGZaaYxnl26CeyCGSBlIemQUXkiZVxiZkdekeGvugcdXxCDQuoPWwnMYymTYVEv0Z1v6LxJQUjnPpnq13DCxuNbg319ekrRbaICx1ijEt85YfcX1H+YzouCoI3WEU4n/JbuDxEirjvCRvCMzkQM8Eo+VNzrIyy0rHHbOcLdl1qtS9JMwyWvcDW501iClwRxe8oo6i4n03Dtcazrp0SMr7aH+uR8cxPB7Eo7M1JyCBqvGvlAA5J90X4uiwGV1ZTrowNyPzCfcpl+F+wamJZPJsihQ183Pe3QOqVjlrin6/T4rVTIxB3bx2TlQY6k85M+mn4N3dbPXUa3BVCbdN7nWTpfBYn1sS/wCVFHjebTy4/kvWvm2bnMmtQndp+0+pUvgxww5T1n7WQeCiSxPwa4ci1N6iedW8RD/diPSshwJ4SnC1crk+SfRh0H7f7z6Bw44PrjKIr0Beqi3Wx+kTeU6zzj+TMnjvgxrgE0a6PporKVY9AzXtNVwYTE4PDomJpsbLc8dGK67gVPJ3SblN+0GvxSX4KdkBmfFVByCadMEbntx3secXyjou03m3kDZA267Na5AJAUAnp5R9MT1doJTJajTyIxNR7oTZ2OrbwNfGdhtF3CtTdHsdVYKoAI363O8CT5P5SqwvrZXDH7Mw1Vg9bD03YALmYG+UXsNN+8yGG2Jg14y4PD6a3NNWI87LOvyu96tDstmt6LTtTxFIct1NvsK48TMPXL7be+H0rbUo4aonHpU2KWZCqAFHBBUqVbi6gaDQ2sbjSKi08xy4dq7VMMz2KlXU8hnzasB9rQg9vTv5F5Ul/KM7N8O2ae5pXzT3ykaFgPPQ8qGrPPLx6BgjSYeKn2gqcpgO0geMv7MV6+tJc46QVt6bxdBpNkvTyWfNmJvfI9rbgMwGU85388ZolLm43YWPs6xPhtmOo1FRDz2ckehCJ0+L6jyj1SB9+ug8+WpxuwzSbRZDZzTAuaZt03ZfW5AlahiaFR1SmcxYkHJUVygAJu1gQBpbU7yJXTD4UHMzUlbdmNEZ+zO9yTLZxOHGhq1KnUoc2/8AjUD0x6o4+l47MQ6Bj6j4TjV2WVVjnvYHTLbmPXOdLaGXShhapvvNkQHtLNm9UHxOMbk0qaD7zlm9QtENRm6xCmxMr01YuMo33F76Drtzy9tHZGIqurPiCig3yIiDNrezOQSR2W3yzhtl5WBux1HOtvCO5xPpV+ngHRQuQmw6j4RPiMK/xh2KPbIBfI1ubntabKtiUWwZgCdQL8Y9ijU+aUcZtOmiM75wqqWYmnUAAUXOrKBzdMW1erO5D0H0Qj0YmsQCq0yCARxmO8X3gWPbCL2P1UsSSBpFpwQJurMpPQdPRGWKOgldJjld1tjNRYw1IoLFs3badrzhXxKLymA7TaVH2xQXlVUH5hHKVhleegxDU4UYRd9ZPMbynV4cYNfrk9imGxpq80M0w9T4RMNuRXY+b95yPDt2+iwlRvM3uEB6t4Wnl5gjwj2k/wBHgiO9/JE9R9tueQiDrtf3w2NN4WM4Y+swykobcYEaEHS/uiXZWy8WDmxFa5+yp08BNAaTEWZr+aEypWQswNYi6sllNwoaxBU71I5xKdTYS5s6NYDcLaax5Uwq5ba/sZSTE5SUbeDY+fcw6ppLuJU22bUHJysOYdnURac2w1QWvSzXtey6X7VmjyiwPNLFFBdQOn3xykwOI2bXXRMIUuWZrOpRiTyhme469JKlsDFMAT5JQemoxYdoCe+fR8bhwy+ESEWJHRIy3Kqcs0vBmr9asi9Qpu3rLr4TQYPZuHQAPSDWAFymYk21Jv0yyjTlisaiXNR1UfeYDxMJTsVNpcHMM7BkVlAFiqu6DTn0I1lVOD2GG+kG75Z/bJlmntzDswVayMTzIc3sy+pU7iPTFRrSjQ2bST6Omid1FXwEuJTnYU5JEi0RzS1USYQSvSuVsDbrG8emcWwDnfWfw9QM02nS6yrvYDz2984PjKKAkugA1NiNO20WYzB0qQz1q6opNsz2UE2JtdjvsD6JT2OuFxYZ6bs6I2XKbAMQAQxA5SkEEfvuXP0fBkdvUyLoGK/bK2XzBiDbr3ShW4U075VqUwfvVEB/0g++NzsmgSGNNWI3ZruB1gNcA9Y1lxKaryVA7AB4Q1fsbjLUduO4vTpCsuvGp5ytxvF1Rlv551TaFV7L8Wr0r3zNkDHqCG+hP2mGlt2txo1pqDcKATvIAufPJxyFapYdVRdEdb6k2uxPSxBLMeskmI9t8IKID0ctRmIZGsjCxZbGzMLXF5p3OhM+YbaxVL4zXzVLDyh0AzWIAB3dYMvGFa4bQxK1ajVDSrKWsSEakFvYXNr7ydT1kzycPjuH6ah68ja+qEfrC9q3eK3DtlZYQnLe3Rj09q01YWcAjrF4mxXA7B1TrSynpUlfCEIQ3tHgLgV/7ZbvMx8TL9Dgvg05OHT/AEiEJSDClgKS8mmg7FEsKgG4D0CEIEkDC89hAPYQhAOdQ3FouxtHNcgcYEW94MIS8U1PZuL+oeTr5j0RxhV46g81z/fTPYSiMnMzGKrWqMCDvOuk8hIz6Vh2lTqg7j4wegj6Mqt2qD4z2ElbjR2ZQU3Skik78qhfCWTTUaZR4z2EImrOHwpazbh1S9Two+16oQmkkTVqnRtzznicQtMXc2HZfwhCOEyXCnYybQAHxioqKQQqKoUlranMtydPNeJ8F8GuEpnMGrFukVCh9KWhCMmlwWAFFbJUrG3261R/bYzt/wBVZTqb94e9f2hCAdV28g0qXXrtmHq19U7VdqoHRC5vUvkyra9hc3JGk8hGFjytLc2p+9dvGYrhPgHWo9UAZHYMCDrcqAbqd2oMIQhUpTZtQi6jQ7tV/eEISkv/2Q=="));
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("customerList",customerList);
    req.getRequestDispatcher("listCustomer.jsp").forward(req,resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
