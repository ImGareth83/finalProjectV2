const productsControl = new ProductsController();

productsControl.displayItem();

renderProductPage() {

        var productHTMLList = [];

        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.name, item.description, item
            .imageUrl);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;


        //addEventListener - click
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];
            document.getElementById(i).addEventListener("click", function() { displayProductDetails(item);} );
        }
}
