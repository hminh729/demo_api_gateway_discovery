# Quy Ước Viết Commit Message

## 1. Cấu Trúc Cơ Bản

Mỗi commit message nên tuân theo cấu trúc sau:

```
<type>(<scope>): <subject>

<body>

<footer>
```

## 2. Type (Loại Commit)

Xác định loại thay đổi được thực hiện:

- **feat**: Thêm tính năng mới
- **fix**: Sửa lỗi
- **docs**: Thay đổi tài liệu
- **style**: Thay đổi định dạng code (không ảnh hưởng logic)
- **refactor**: Cải thiện code mà không thêm tính năng hoặc sửa lỗi
- **perf**: Cải thiện hiệu năng
- **test**: Thêm hoặc cập nhật test
- **chore**: Cập nhật dependencies, build script, config,...
- **ci**: Thay đổi CI/CD configuration

## 3. Scope (Phạm Vi)

Phạm vi của thay đổi:

- Ví dụ: `auth`, `user`, `product`, `payment`, `api`, `ui`, v.v.
- Scope là tùy chọn nhưng khuyến khích sử dụng

## 4. Subject (Chủ Đề)

Mô tả ngắn gọn về thay đổi:

- Sử dụng động từ mệnh lệnh (Add, Fix, Update, Remove,...)
- Không viết hoa chữ cái đầu (trừ khi là tên riêng)
- Không kết thúc bằng dấu chấm
- Giới hạn dưới 50 ký tự

## 5. Body (Nội Dung Chi Tiết)

Mô tả chi tiết về thay đổi:

- Giải thích **tại sao** thay đổi, không phải **cái gì** đã thay đổi
- Mỗi dòng không quá 72 ký tự
- Cách ra khoảng trống 1 dòng sau subject
- Tùy chọn nhưng khuyến khích cho các commit quan trọng

## 6. Footer (Kết Luận)

Thông tin bổ sung như:

- Tham chiếu issue: `Closes #123` hoặc `Fixes #456`
- Breaking changes: `BREAKING CHANGE: ...`
- Co-authored-by: `Co-authored-by: Name <email>`

## 7. Ví Dụ Commit Message

### Ví dụ 1: Commit đơn giản
```
feat(auth): add login functionality
```

### Ví dụ 2: Commit có body
```
fix(payment): resolve timeout issue in payment processing

The payment API was timing out due to slow database queries.
Optimized the query by adding an index on the transaction_id column.

Closes #1234
```

### Ví dụ 3: Commit refactor
```
refactor(api): simplify user service code

- Extract validation logic to separate function
- Remove duplicate code in controller methods
- Update unit tests accordingly

BREAKING CHANGE: getUserById() now returns null instead of throwing error
```

## 8. Quy Tắc Chung

✅ **Nên làm:**
- Viết commit message chi tiết và có ý nghĩa
- Sử dụng tiếng Anh (hoặc tiếng Việt nếu team quy định)
- Commit thường xuyên với các thay đổi nhỏ
- Kiểm tra code trước khi commit
- Tham chiếu issue hoặc task liên quan

❌ **Không nên làm:**
- Viết commit message quá ngắn hoặc không có ý nghĩa
- Commit tất cả thay đổi cùng một lúc
- Sửa lỗi chính tả sau khi push
- Thay đổi commit message sau khi push lên remote
- Mix nhiều loại thay đổi trong một commit

## 9. Mẹo Hữu Ích

```bash
# Xem lịch sử commit
git log --oneline

# Sửa commit message gần nhất
git commit --amend -m "new message"

# Xem chi tiết commit
git show <commit-id>

# Tìm commit theo keyword
git log --grep="keyword"
```

## 10. Khuyến Nghị Bổ Sung

- Nếu commit liên quan đến task, hãy tham chiếu task ID
- Sử dụng format: `[TASK-123] feat(module): add feature`
- Đảm bảo mỗi commit có thể build và test được
- Tránh commit code chưa hoàn thành
