function findProductById(pcart, productId) {
    for (let i = 0; i < pcart.length; i++) {
        if (pcart[i].productID === productId) {
            return pcart[i];
        }
    }
    return null; // Return null if product not found
}

function add_to_cart(pid, pname, price) {
    let cart = JSON.parse(localStorage.getItem("cart")) || []; // Parse the cart from localStorage
    let pcart = Array.isArray(cart) ? cart : []; // Ensure pcart is an array

    let oldProduct = findProductById(pcart, pid);
    if (oldProduct) {
        oldProduct.productQuantity++;
    } else {
        let product = { productID: pid, productName: pname, productQuantity: 1, productPrice: price };
        pcart.push(product);
    }

    localStorage.setItem("cart", JSON.stringify(pcart));

}

//updating cart
function update_Cart()
{
    let cartString=localStorage.getItem("cart");
    let cart=JSON.parse(cartString);
    if(cart===null||cart.length===0){
        console.log("Cart is empty");
        $(".cart-items").html("(0)");
        $(".cart-body").html("<h3>Cart does not have any items</h3>");
        $(".checkout-btn").addClass('disabled');
    }
    else{
        let totalQuantity = 0;
        console.log(cart.length);
        for (let i = 0; i < cart.length; i++) {
            totalQuantity += cart[i].productQuantity;
        }
        console.log(cart);
        $(".cart-items").html(`(${totalQuantity})`);
        let table=`<table class='table'>
                    <thead class='thead-light'>
                        <tr>
                            <th>Item Name    </th>
                            <th>Price    </th>
                            <th>Quantity     </th>
                            <th>Total Price      </th>
                            <th>Action    </th>
                        </tr>
                    </thead>
                    
`;
        let totalPrice=0;
       
     for (let i = 0; i < cart.length; i++) {
    let item = cart[i];
    table += "<tr>" +
                "<td>" + item.productName + "</td>" +
                "<td>" + item.productPrice + "</td>" +
                "<td>" + item.productQuantity + "</td>" +
                "<td>" + (item.productQuantity * item.productPrice) + "</td>" +
                "<td><button onclick='deleteItemFromCart(" + item.productID + ")' class='btn btn-danger btn-sm'>Remove</button></td>" +
            "</tr>";
    totalPrice += item.productPrice * item.productQuantity;
}

        table=table+`<tr><td colspan='5' class='text-right font-weight-bold m-5'> Total Price : ${totalPrice}</td></tr>
                        </table>`;
        
             $(".cart-body").html(table);
              $(".checkout-btn").removeClass('disabled');
    }
}
//delete item
//delete item
//delete item
function deleteItemFromCart(pid){
    console.log("Deleting item with productId:", pid);
    let cart=JSON.parse(localStorage.getItem('cart'));
    console.log("Current cart:", cart);
    let newcart= cart.filter((item)=> item.productID !== pid);
    console.log("New cart after deletion:", newcart);
    localStorage.setItem('cart',JSON.stringify(newcart));
    update_Cart();
}

$(document).ready(function(){
    update_Cart();
});

function goToCheckout(){
    window.location="checkout.jsp";
}
function removeItems() {
    console.log("Deleting all items from cart");
    localStorage.removeItem('cart');
    update_Cart();
}
