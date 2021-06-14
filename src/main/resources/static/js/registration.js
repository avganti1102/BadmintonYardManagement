//
//
// $(document).ready(function () {
//
//     $('#createCategoryGroupButton').click(function () {
//         let categoryGroupTitle = $('#category-group-title').val();
//         let ajaxUrl = urls.createCategoryGroup;
//         let ajaxData = {title: categoryGroupTitle};
//         if (categoryIdSelect !== 0) {
//             ajaxUrl = urls.updateCategoryGroup;
//             ajaxData = {
//                 id: categoryIdSelect,
//                 title: categoryGroupTitle
//             };
//         }
//         if (categoryGroupTitle && categoryGroupTitle.trim().length > 0) {
//             $("#createCategoryGroupButton").prop('disabled', true);
//             $.ajax({
//                 type: "POST",
//                 contentType: 'application/json',
//                 url: ajaxUrl,
//                 dataType: 'json',
//                 data: JSON.stringify(ajaxData),
//                 cache: false,
//             }).done(function (response) {
//                 let categoryGroup = response.data;
//                 if (categoryIdSelect !== 0) {
//                     $('#' + typeSelect + categoryIdSelect + " span").text(categoryGroup.title);
//                     $(".btn-update-category[data-is-category='" + typeSelect + "'][data-category-id='" + categoryIdSelect + "']").data('category-title', categoryGroup.title);
//                     $(".btn-delete-category[data-is-category='" + typeSelect + "'][data-category-id='" + categoryGroup.id + "']").data('category-title', categoryGroup.title);
//                     $('#createCategoryGroupModal').modal('hide');
//                     $('#category-group-title').val('');
//                     categoryIdSelect = 0;
//                 } else {
//                     $('#categoryGroups .drag-sort-category-group').append(dataItem(categoryGroup.id, 'category-group'));
//                     $('#' + 'category-group' + categoryGroup.id + " span").text(categoryGroup.title);
//                     $(".btn-update-category[data-is-category='category-group'][data-category-id='" + categoryGroup.id + "']").data('category-title', categoryGroup.title);
//                     $(".btn-delete-category[data-is-category='category-group'][data-category-id='" + categoryGroup.id + "']").data('category-title', categoryGroup.title);
//                     $('#createCategoryGroupModal').modal('hide');
//                     $('#category-group-title').val('');
//                     dragSortCategoryGroup();
//                 }
//                 $("#createCategoryGroupButton").prop('disabled', false);
//             }).fail(function (response) {
//                 $("#errorMes").text(response.responseJSON.message);
//                 $("#createCategoryGroupButton").prop('disabled', false);
//             });
//         } else {
//             $("#errorMes").text(MESSAGE_CATEGORY_GROUP_NOT_BLANK);
//         }
//     })
// })
