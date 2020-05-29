class NetWork {
    static get = async function (url, data) {
        return await $.ajax({
            url: url,
            type: "get",
            contentType: "application/json",
            dataType: "json",
            timeout: 10000,
            data: data,
            success: async function (data) {
                return data;
            }
        });
    };

    static post = function (url, data, callback) {
        $.ajax({
            url: url,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: data,
            timeout: 60000,
            success: function (msg) {
                callback(msg);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    };

    static put = function (url, data, callback) {
        $.ajax({
            url: url,
            type: "put",
            contentType: "application/json",
            dataType: "json",
            data: data,
            timeout: 20000,
            success: function (msg) {
                callback(msg);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    };

    static del = function (url, data, callback) {
        $.ajax({
            url: url,
            type: "delete",
            contentType: "application/json",
            dataType: "json",
            data: data,
            success: function (msg) {
                callback(msg);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    };
}