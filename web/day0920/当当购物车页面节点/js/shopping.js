/*关闭窗口*/
function closeMe(){
    window.close();
}
function collection(){
    var flag=confirm("移入收藏后，将不再购物车显示，是否继续操作?");
    if(flag==true){
        alert("移入收藏成功!");
    }
}
function del(){
    var flag=confirm("您确定要删除商品吗?");
    if(flag==true){
        alert("删除成功!");
    }
}
function account(){
    var flag=confirm("您本次购买的商品信息如下：\n\n商品名称：白岩松：白说、岛上书店；\n商品数量：2件；\n商品总计：46.00；\n运费：0元；\n\n请确认以上信息是否有误！！！");
    if(flag){
        alert("您的订单已提交");
    }

}
//计算购物车商品总金额
function total(){
    //分别拿到所有商品的单价及数量
    var prices = document.getElementsByName("price");
    var amounts = document.getElementsByName("amount");
    //总金额
    var sum = 0;
    for(var i=0;i<prices.length;i++){
        sum+=prices[i].value*amounts[i].value;
    }
    //将总金额显示在正确位置上<li id="totalPrice">&nbsp;</li>
    document.getElementById("totalPrice").innerHTML="￥"+sum;
}
total();
//商品数量增加的操作  index：哪一个account修改,集合中的哪一个商品元素（单价、数量对应的下标）
function plus(index){
    //1 改变每个商品增加数量后的新数量
    //拿到商品数量原来的值
    var count = parseInt(document.getElementsByName("amount")[index].value);
    //让商品数量原来的值+1
    //让商品数量变为+1以后的新的数量值
    document.getElementsByName("amount")[index].value=count+1;
    //2 修改数量后每个商品的总金额要相应修改
    var totalPer = parseFloat(document.getElementsByName("price")[index].value*(count+1));
    document.getElementById("totalprice"+index).innerHTML = "￥"+totalPer;
    //3 所有商品的总金额也要相应修改
    total();
}
//商品数量减少的操作  index：哪一个account修改,集合中的哪一个商品元素（单价、数量对应的下标）
function minus(index){
    //1 改变每个商品减少数量后的新数量
    //拿到商品数量原来的值
    var count = parseInt(document.getElementsByName("amount")[index].value);
    if(count==1){
        //对商品数量做一个判断，当当前商品数量已经=1的情况下，不能再减少了
        alert("不能再减少了，再减就没有啦！");
    }else{
        //让商品数量原来的值-1
        //让商品数量变为-1以后的新的数量值
        document.getElementsByName("amount")[index].value=count-1;
        //2 修改数量后每个商品的总金额要相应修改
        var totalPer = parseFloat(document.getElementsByName("price")[index].value*(count-1));
        document.getElementById("totalprice"+index).innerHTML = "￥"+totalPer;
        //3 所有商品的总金额也要相应修改
        total();
    }
}