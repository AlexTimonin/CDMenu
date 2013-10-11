CDMenu
======

Customizable Dialog Menu for Android to replace default ContextMenu.

You can use it like default ContextMenu with default customization or you can customize it using your ListView layout, ListViewItem layout, StyleDelegate and other features.

*> TODO: Add logo/screenshots.*

*Project was developed using Document-Driven Development. You can read the [documentation here](https://github.com/BeKitzur/CDMenu/wiki) before use this control.*

Installation
============

Download `/library` folder and import it to your project as module.

How to use
==========

Customizable Dialog Menu is easy to use control.

Here is quick example of usage:

    CDMenu.createDialogMenu(context)
        .setData(R.menu.main_menu)
        .setOnItemClickListener(this)
        .show();

You can use your custom list view layout and list item:

    CDMenu.createDialogMenu(context)
        .setData(R.menu.main_menu)
        .setOnItemClickListener(this)
        .setCustomListView(ListView or R.layout.your_list_view)
        .setCustomListItem(R.layout.your_item_layout, R.id.text_view_id, this)
        .show();

More examples in [Samples Project](https://github.com/BeKitzur/CDMenu/tree/master/samples)

**Samples project contains following examples:**

1. Shows a default Android context menu, populated with a menu resource xml
2. Shows a CDMenu populated with a menu resource xml
3. Shows a CDMenu populated with a Menu object
4. Shows a CDMenu populated with a menu resource xml, containing several layers of submenus
5. Shows a CDMenu with its ListView inflated from a custom layout resource xml file
6. Shows a CDMenu with its ListView set by passing in the object
7. Shows a CDMenu with its ListView items' layout inflated from a custom layout resource xml file
8. Same as 7, but also handles a callback to manually update custom list items, used in case their layouts need more than just main TextViews to be updated

License (MIT)
=============

Copyright (C) 2013 BeKitzur, Andrey Cherkashin, Alex Timonin, Sergey Arkhipov

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.